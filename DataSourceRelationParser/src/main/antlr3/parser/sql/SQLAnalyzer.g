grammar SQLAnalyzer; 
 
options {
  language=Java;
	backtrack = true;
	memoize = true;
} 

@header {
package parser.sql;
}


@lexer::header{
package parser.sql;
} 

@rulecatch { catch (RecognitionException re) { throw re; } }

@members {
/*
 * 컬럼 정보
 */
private ArrayList <String> columnList = new ArrayList<String>();
/*
 * alias 테이블 정보
 */
private ArrayList<String> aliasTableList = new ArrayList<String>();
/*
 * select테이블 정보
 */
private ArrayList<String> selectTableList  = new ArrayList<String>();
/*
 * 테이블 정보
 */
private ArrayList<String> tableList = new ArrayList<String>();
/*
 * statementType 정보 
 */
private ArrayList<String> statementTypeList = new ArrayList<String>();
private boolean isExistColumnName = false;
/*
 * db2 더미 테이블
 */
private String db2DummyTableNameOne =  "SYSIBM.SYSDUMMY1";
private String db2DummyTableNameTwo =  "SYSDUMMY1";
private String db2DummyTableNameThree =  "DUMMY";
/*
 * 현재 statementType 정보 
 */
private String statementType;
/*
 * Statement 인덱스
 */
private int statementIdx = 0 ;

public List<String> getTableList() {
  return tableList;
}

public List<String> getAliasTableList() {
  return aliasTableList;
}

public List<String> getColumnList() {
  return columnList;
}

public List<String> getSelectTableList(){
  return selectTableList;
}

public void setStatementType(String type) {
  this.statementType = type;
}

public String getStatementType() {
  return this.statementType;
}

}

statement :
   { setStatementType("01");} i = insertStatement (SEMICOLON)? {
        /*
         * columnNameList를 선언하지 않았으면
         * 모든 컬럼이 사용되는 컬럼이므로 
         * '*'를 column에 추가한다.
         */
        if(!isExistColumnName){
           columnList.add("*");
        } else {
          // DO NOTHING 
        }
   }
  | { setStatementType("02");} s = selectStatement (SEMICOLON)?    
  | { setStatementType("03");} o =  updateStatement (SEMICOLON)?
  | { setStatementType("04");} d =  deleteStatement (SEMICOLON)?  
  | { setStatementType("05");} m = mergeStatement (SEMICOLON)?
  | { setStatementType("02");} s = withStatement (SEMICOLON)?
  ;
 
insertStatement :
  INSERT ( INTO )?
    (o = dbObject)? 
      {
      //insert table add withStatement
      // not null, not dual, not exist
      if(($dbObject.text) != null && !(("dual").equalsIgnoreCase($dbObject.text))
          &&!((db2DummyTableNameOne).equalsIgnoreCase($dbObject.text)) 
          &&!((db2DummyTableNameTwo).equalsIgnoreCase($dbObject.text)) 
          &&!((db2DummyTableNameThree).equalsIgnoreCase($dbObject.text))){
        String tableName = $dbObject.text;
        // 대문자로 변경
        tableName = tableName.toUpperCase();
        // erase DB LINK
        if(tableName.contains("@")){
            String [] splitTableName = tableName.split("@");
            tableName = splitTableName[0];
        } 
        if(!tableList.contains(tableName)){
            tableList.add(tableName);
        }// end if
      }// end if 
    }
    (LPAREN c = columnNameList RPAREN )? ( WITH al = alias1 (AS)?)? 
    {
      // alias가 존재하면 aliastable에 add
      String alias = $al.text;
      aliasTableList.add(alias);
    
    }
     ( VALUES LPAREN e = columnValueList RPAREN 
    | ( selectStatement )* )

  ;

selectStatement  :
{ 
  // 원래의 StatementType을 리스트에 저장하고 Type을 SELECT로 SET한다.
  statementTypeList.add(statementIdx, getStatementType());
  setStatementType("02"); 
  statementIdx++;

 }
  q = queryExpression 
   {
     // SelectStatement가 종료된후에는 Type을 이전에 저장했던 Statement로 변경한다.
      statementIdx--;
      setStatementType(statementTypeList.get(statementIdx)); 
    } 
  ;

updateStatement :
  UPDATE 
   ( t = tableSource )? 
    SET a = assignmentList 
    ( // cursors not supported
      w = whereClause 
    )?
  ;

deleteStatement :
  DELETE  ( FROM )?
    t = tableSource 
    ( // cursors not supported
      w = whereClause 
    )?
  ;
  
mergeStatement  :
  (MERGE INTO) tableSource
  USING (selectStatement)? identifier ON searchCondition 
  ((WHEN MATCHED THEN) updateStatement)?
  ((WHEN NOT MATCHED THEN) insertStatement)? ;
  
  
withStatement   : 
  WITH  ( (COMMA)?  
    a = identifier 
   ( LPAREN (( COMMA )? identifier )+ RPAREN )?
      (AS)? LPAREN 
    // aliasTableList add
    {
      String aliasTableName = $a.text;
      aliasTableList.add(aliasTableName);
     }
      ( selectStatement 
        | ((VALUES | COMMA)? LPAREN ( 
          (COMMA)? subExpression )*)+ RPAREN )+
       RPAREN )+  
     (selectStatement)*
;   

  
assignmentList  :
  a = assignment  (COMMA a = assignment)*
  ;

assignment  :
  ( c = column  ASSIGNEQUAL v = columnValue )  
  ;

columnNameList  :
  c = column 
    ( COMMA c = column  )*  {
    isExistColumnName = true;
    // Insert Column add
    String column = $columnNameList.text;
     if(column !=null && !(column).equals("\\'\\'")){ 
        String[] tmps = column.split("\\,");
        
        for(String columns : tmps) {
          String trimColumn = columns.trim();
            if(trimColumn.contains(".")){
              String [] splitColumn = columns.split("\\.");
              trimColumn = splitColumn[1];
              
              if(trimColumn.equals("NEXTVAL")){
                trimColumn = splitColumn[0];
              }
            }
            // 추가적으로 trim실행
            trimColumn = trimColumn.trim();
            trimColumn = trimColumn.toUpperCase();
            if(!columnList.contains(trimColumn)){
              columnList.add(trimColumn);
            }
        } 
      }
     }
    
  ;

columnValueList  :
  v = columnValue  ( COMMA v = columnValue  )*
  ;
  

columnValue  :
  DEFAULT 
  | e = expression 
  ;

queryExpression  :
  s = subQueryExpression  
  ( u = unionOperator
    s = subQueryExpression 
  )*
    ( o = orderByClause )?
  ( fetchClause )?
  ( optimizeClause )?
  ( withClause )?
  ( startClause )?
  ;

subQueryExpression  :
   s = querySpecification  
  | LPAREN s = queryExpression RPAREN 
  ;

querySpecification  :
  s = selectClause 
  ( f = fromClause  )?
  ( w = whereClause  )?
  ( g = groupByClause )?
    ( h = havingClause  )?
    ( o = orderByClause )?
  ( fetchClause )?
  ( optimizeClause )?
  ( withClause )?
  ( startClause )?
  
  ;

selectClause  :
  SELECT 
  ( ALL | DISTINCT  )?
  //(TOP Integer )?
  s = selectList 
  ;

whereClause  :
  WHERE c = searchCondition 
  ;

orderByClause  :
  ORDER BY
  e = orderExpression 
  ( COMMA e = orderExpression  )*
  ;

orderExpression  :
  e = expression  
  ( ASC | DESC  | NULLS FIRST)?
  ;

groupByClause  :
  GROUP BY 
    ( ALL  )?
   e = expression  ( COMMA ie =  expression )* 

  ;

havingClause  :
  HAVING c = searchCondition 
  ;

  
fetchClause :
  FOR? FETCH FIRST? expression? rowAndRows? ONLY
 ;
 
optimizeClause :
OPTIMIZE FOR expression rowAndRows
;
 
withClause :  
  (FOR READ ONLY)? WITH UR;
  
startClause :
  START WITH searchCondition CONNECT BY PRIOR searchCondition;
 
rowAndRows :
 ROW | ROWS
 ;
  
searchCondition  :
  e = additiveSubSearchCondition 
    ( OR r = additiveSubSearchCondition
    )*
  ;

additiveSubSearchCondition  :
  e = subSearchCondition 
    ( AND r = subSearchCondition 
    )*
  ;

bracketedSearchCondition  :
  LPAREN e = searchCondition RPAREN 
  ;

subSearchCondition  :
  ( NOT )? (
    (bracketedSearchCondition) =>
      e = bracketedSearchCondition  (comparisonOperator expression)?
    | p = predicate 
    )
  ;

  
predicate  :
    l = expression  (plusSignature)?     
   (
          o = comparisonOperator (
                r = expression (plusSignature)?
      | q = quantifierSpec
        LPAREN s = selectStatement RPAREN 
            )
    | IS 
      ( NOT )? NULL
    | ( NOT )? (
      LIKE e = expression 
        ( ESCAPE f = expression )? 
      | BETWEEN e = expression AND f = expression 
      | IN ( LPAREN )? (
        ( selectStatement ) =>
          s = selectStatement 
        | (VALUES | COMMA)? e = expression 
          ( COMMA e = expression )*
        ) ( RPAREN )? ))
      | EXISTS LPAREN s = selectStatement RPAREN 
      | function
      | startClause
  ;

quantifierSpec  :
  ALL 
  | SOME 
  | ANY 
  ;

selectList  :
  s = selectItem 
    ( COMMA t = selectItem )*
  ;

selectItem  :
   STAR
  | dbObject DOT_STAR   // "*, *" is a valid select list
  | (
    (alias2) => (
      a = alias2 e = expression 
    )
    | (tableColumns) => t = tableColumns 
    | id = expression ( db2Element )? (a = alias1)?
  )  
  ;

fromClause  :
  FROM ( TABLE )? tableSource 
  ( COMMA t = tableSource )*
  ;

tableSource  :
  t = subTableSource 
  ( t = joinedTable )* 
  ;

subTableSource  :
  LPAREN (
    (joinedTables) =>
      t = joinedTables RPAREN 
    | q = queryExpression RPAREN (al = alias1)? 
        )
  |  f = function ( a = alias1 )? 
  | LPAREN VALUES constant RPAREN (al = alias1)
  | ta =  dbObject ( al = alias1 )? 
  {
  // select, DELETE, UPDATE table add
      // not null, not dual, not exist
//      if(($ta.text) != null && !(("dual").equalsIgnoreCase($ta.text))
//        &&("")){
        if(($ta.text) != null && !(("dual").equalsIgnoreCase($ta.text))
          && !((db2DummyTableNameOne).equalsIgnoreCase($ta.text))
          && !((db2DummyTableNameTwo).equalsIgnoreCase($ta.text))
           && !((db2DummyTableNameThree).equalsIgnoreCase($ta.text))){
        String tableName = $ta.text;
        String alias = $al.text;
        
        // erase DB LINK
        if(tableName.contains("@")){
            String [] splitTableName = tableName.split("@");
            tableName = splitTableName[0];
        } 

        // alias 가 null이 아니면 aliasList에 add
        if(alias != null){
          aliasTableList.add(alias);
        } 

        // 대문자로 변환
        tableName = tableName.toUpperCase();
        // alias Table에 존재하지 않는다.
        if(!aliasTableList.contains(tableName)) {
          // type이 select이다.
          if(getStatementType().equals("02")){
            // 중복 되는 테이블이 없다.
            if(!selectTableList.contains(tableName)){
              selectTableList.add(tableName);
            } else {/* DO NOTHING */}
          } else {
            // select가 아니고 중복 되는 테이블이 없다.
            if(!tableList.contains(tableName)){
              tableList.add(tableName);
            } else { /* DO NOTHING */ }
         }
        } else {/* DO NOTHING */} 
        
      }// end if 
     }
  ;

joinOn :
  ( INNER
  | ( LEFT 
    | RIGHT 
    | FULL )
    ( OUTER )? 
  )? JOIN ( TABLE )?
  ;

joinedTable :
  CROSS JOIN t = subTableSource 
  | (
    j = joinOn
      t = tableSource 
      ON c = searchCondition 
    )
  ;

joinedTables :
  t = subTableSource 
    ( t = joinedTable )+
  ;

// edge cases (single-quoted literal but not for table names &
// keywords as identifiers) not supported
alias1  :
  (AS)? i = identifier (AS)?
  ;

alias2  :
  i = identifier 
  ASSIGNEQUAL
  ;

tableColumns :
  o = dbObject DOT_STAR 
  ;
 
// "++column_name" not supported
column  :
  d = dbObject {
    String column = $d.text;
    //select Column이 아닌 경우 
    if(!getStatementType().equals("02")){
      if(column !=null && !(column).equals("\\'\\'")) {
           if(column.contains(".")){
             String [] splitColumn = column.split("\\.");
             column = splitColumn[1];
             
             // NEXTVAL 이면, . 앞이 컬럼
             if(column.equals("NEXTVAL")){
              column = splitColumn[0];
            }
           }
          column = column.toUpperCase();
          if(!columnList.contains(column)){
              columnList.add(column);
           }
         } 
    
    } else {
      //selectColumn인 경우 담지 않는다.
    }
   }
  | LPAREN o = column ( COMMA o = column )* RPAREN  {
    String column = $o.text;
      //select Column이 아닌 경우 
if(!getStatementType().equals("02")){
      if(column !=null && !(column).equals("\\'\\'")) {
           if(column.contains(".")){
             String [] splitColumn = column.split("\\.");
             column = splitColumn[1];
              
              // NEXTVAL 이면, . 앞이 컬럼
             if(column.equals("NEXTVAL")){
              column = splitColumn[0];
            }
           }
          column = column.toUpperCase(); 
          if(!columnList.contains(column)){
              columnList.add(column);
           }
       }// end if 
     } // selectType이 아닐때 ColumnAdd
   }
  ;

expression :
  e = additiveSubExpression  
  ( o = additiveOperator r = additiveSubExpression )*
  ;

additiveSubExpression  :
  e = subExpression 
  ( ( o = multiplicativeArithmeticOperator )? r = subExpression )*
  ;

bracketedTerm  : 
  LPAREN ( selectStatement (expression)? | e = functionArgument* ( COMMA expression )* ) RPAREN 
  ;

subExpression  :
  ( o = unaryOperator )? (
    c = constant 
    | a = sharpObject
    | g = groupFunction
    | da = datetimeField
    | t =  db2Element
    | v = variableReference 
    | PLACEHOLDER 
    | (function) =>
      f = function 
    | e = bracketedTerm 
    | d = dbObject (plusSignature)?
 
     {
       String column = $d.text;
       
    // update Column, GROUPBY COLUMN add
if(!getStatementType().equals("02")){
        if(column !=null && !(column).equals("\\'\\'")) {
           if(column.contains(".")){
             String [] splitColumn = column.split("\\.");
             column = splitColumn[1];
             
              // NEXTVAL 이면, . 앞이 컬럼
             if(column.equals("NEXTVAL")){
              column = splitColumn[0];
            }
           }
          column = column.toUpperCase(); 
          if(!columnList.contains(column)){
              columnList.add(column);
           }
         } 
    
    } else {
       //statementType이 select이면 addㅎㅏ지 않는다.
    }
   }
                // parameterless functions not supported - there
                // don't seem to be any portable ones...
    | p =  caseFunction
    | q = castFunction

  ) 
  ;

variableReference  :
  Variable 
  ;

// todo: create a separate rule for aggregate functions
function  :
  SUBSTRING  LPAREN v = expression  FROM s = expression  ( FOR l = expression )? RPAREN
  | (EXTRACT)? LPAREN d = datetimeField (FROM)? s = expression  RPAREN
  | f = genericFunction
  ;

genericFunction :
  // LEFT and RIGHT keywords are also function names
  (
    // MS SQL Sedb2Elementrver 2005 doesn't accept quoted identifiers
    // (e.g. [count]) as function names
    (NonQuotedIdentifier DOT)? NonQuotedIdentifier 
    | LEFT 
    | RIGHT 
  ) LPAREN (
    e = functionArgument   ( functionArgument )? 
      ( COMMA e = functionArgument )*
    // aggregate functions like Count(), Checksum()
    // accept "*" as a parameter
    | STAR 
          | (ALL | DISTINCT ) (
      STAR 
      // aggregate function
      | e = expression 
    )
    // named arguments not supported
        )? RPAREN ( expression )?
  ;

functionArgument  
: e = expression 
  | d = datetimeField 
  ;
  
groupName :
    MAX 
     | SUM 
     | AVG  
     | MIN 
     | NVL  
     | DATE
     | TIME 
     | TIMESTAMP
     | MONTH
     | INT
     | VALUE
     | OVER
     | ROW UNDERSCOPE NUMBER
     | DENSE UNDERSCOPE RANK
     | RANK
     | DECODE
    ;
    
groupFunction  : 
  groupName LPAREN 
    (ALL | DISTINCT | PARTITION BY)? 
    ( c = functionArgument (COMMA b = functionArgument )* )? 
    ( orderByClause )? 
    RPAREN 
  ;

caseFunction  :
  CASE  (
    a = expression 
      ( WHEN e = expression THEN f = expression )+
  // boolean expressions
        | ( WHEN e = searchCondition (comparisonOperator expression)? THEN f = expression )+
        )
    ( ELSE e = expression )? END ( CASE )? // Oracle acepts both terminators
  ;

//caseFunction  :
//  CASE  (
//    a = expression 
//      ( WHEN e = expression THEN f = expression )+
//  // boolean expressions
//        | ( WHEN e = searchCondition THEN f = expression )+
//        )
//    ( ELSE e = expression )? END ( CASE )? // Oracle acepts both terminators
//  ;

castFunction  :
  CAST LPAREN e = expression AS t = expression 
    ( LPAREN p = nonNegativeInteger  ( COMMA p = nonNegativeInteger )? RPAREN )? 
    RPAREN
  ;
  
/*
sharpObject 
  :  ('#' | '$') 
  (d = identifier 
    | function 
    | DISTINCT 
  | NUMBER
  | VALUE 
  )( DOT ( db = dbObject | function )) * ('#' | '$')
   ;   
*/

sharpObject :
  (identifier DOT)? UicodeValueLiteral
  ; 

dbObject  :
   i = identifier   
  ( DOT ic = identifier )? 

  ;


// OracleJoin Signature
plusSignature 
  : LPAREN PLUS RPAREN ;
  
// SQL 92 allows string literals broken by whitespace/comments
// (as long as it contains a newline - we're more permissive than that,
// and also allow mixing ASCII parts into Unicode strings).
stringLiteral  :
  (s = singleStringLiteral)+
  ;

singleStringLiteral  :
   UnicodeStringLiteral
  | AsciiStringLiteral  
  ;

identifier  :
  NonQuotedIdentifier 
  | QuotedIdentifier
  | DESC
  | ORDER
  | orderByClause 
  | GROUP 
  | groupByClause
  | groupName
  | datetimeField
  | db2Element
  | INTERVAL
 ;

typeIdentifier  :
  NonQuotedIdentifier 
  ;

constant  :
  i = nonNegativeInteger 
  | Real 
  | NULL 
  | s = stringLiteral 
  | j = intervalLiteral 
  | HexLiteral 
  // subset of an MS Access-specific format
  | MAccessDateTime 
  // subset of ISO 8601 recommended for SQL Server 2005
  | Iso8601DateTime 
  | TIMESTAMP s = stringLiteral 
  // currency & system variables not supported
  ;

intervalLiteral  :
  INTERVAL ( u = unaryOperator  )? AsciiStringLiteral  d = datetimeField  ( LPAREN Integer  RPAREN )?
  ;

nonNegativeInteger  :
  Integer
  ;

unaryOperator  :
  PLUS 
  | DASH 
  ;

additiveOperator  :
  PLUS 
  | DASH 
  | STRCONCAT 
  ;
    
multiplicativeArithmeticOperator :
  STAR 
  | DIVIDE 
  | MOD 
  ;
    
comparisonOperator  :
  ASSIGNEQUAL 
  | NOTEQUAL1 
  | NOTEQUAL2 
  | LESSTHAN 
  | LESSTHANOREQUALTO1
  | GREATERTHANOREQUALTO1 
  | GREATERTHAN 
  | BETWEEN subExpression AND 
  ;

unionOperator  :
  UNION 
  ( ALL )?
  | MINUS
  ;

datetimeField  :
  YEAR 
  | MONTH 
  | DAY 
  | HOUR 
  | MINUTE 
  | SECOND 
  | DATE
  ;
db2Element  :
  CURRENT (TIMESTAMP | DATE | TIME)
  | UPDATE (TIMESTAMP | DATE | TIME)
  | CURRENT
  | TIMESTAMP
  | SYSDATE
  | DATE
  | INT
  | YEARS
  | YEAR
  | CURRENT_DATE
  | CURRENT_TIME
  | CURRENT_TIMESTAMP
  | NEXT VALUE FOR
  ;
  
ALL : A_ L_ L_;
AND : A_ N_ D_;
ANY : A_ N_ Y_;
AS : A_ S_;
ASC : A_ S_ C_;
AVG : A_ V_ G_;
BETWEEN : B_ E_ T_ W_ E_ E_ N_ ;
BY : B_ Y_;
CASE : C_ A_ S_ E_ ;
CAST : C_ A_ S_ T_;
CONNECT : C_ O_ N_ N_ E_ C_ T_ ;
CROSS : C_ R_ O_ S_ S_;
CURRENT : C_ U_ R_ R_ E_ N_ T_;
CURRENT_DATE : C_ U_ R_ R_ E_ N_ T_ UNDER_ D_ A_ T_ E_;
CURRENT_TIME : C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_;
CURRENT_TIMESTAMP : C_ U_ R_ R_ E_ N_ T_ UNDER_ T_ I_ M_ E_ S_ T_ A_ M_ P_ ;
DATE : D_ A_ T_ E_;
DAY : D_ A_ Y_;
DECODE : D_ E_ C_ O_ D_ E_; 
DEFAULT : D_ E_ F_ A_ U_ L_ T_;
DELETE : D_ E_ L_ E_ T_ E_;
DENSE : D_ E_ N_ S_ E_; 
DESC : D_ E_ S_ C_;
DISTINCT : D_ I_ S_ T_ I_ N_ C_ T_;
ELSE : E_ L_ S_ E_;
END : E_ N_ D_;
ESCAPE : E_ S_ C_ A_ P_ E_;
EXISTS : E_ X_ I_ S_ T_ S_;
EXTRACT : E_ X_ T_ R_ A_ C_ T_;
FETCH : F_ E_ T_ C_ H_;
FIRST : F_ I_ R_ S_ T_;
FOR : F_ O_ R_;
FROM : F_ R_ O_ M_ ;
FULL : F_ U_ L_ L_;
GROUP : G_ R_ O_ U_ P_ ;
HAVING : H_ A_ V_ I_ N_ G_ ;
HOUR : H_ O_ U_ R_ ;
IN : I_ N_ ;
INNER : I_ N_ N_ E_ R_ ;
INSERT : I_ N_ S_ E_ R_ T_ ;
INTERVAL : I_ N_ T_ E_ R_ V_ A_ L_ ;
INT : I_ N_ T_;
INTO : I_ N_ T_ O_ ;
IS : I_ S_ ; 
JOIN : J_ O_ I_ N_ ;
LEFT : L_ E_ F_ T_ ;
LIKE : L_ I_ K_ E_ ;
MATCHED : M_ A_ T_ C_ H_ E_ D_ ;
MAX : M_ A_ X_;
MERGE : M_ E_ R_ G_ E_ ;
MIN : M_ I_ N_;
MINUS : M_ I_ N_ U_ S_ ;
MINUTE : M_ I_ N_ U_ T_ E_;
MONTH : M_ O_ N_ T_ H_ ;
NEXT : N_ E_ X_ T_ ;  
NOT : N_ O_ T_ ;
NULL : N_ U_ L_ L_ ;
NULLS : N_ U_ L_ L_ S_ ;
NUMBER  : N_ U_ M_ B_ E_ R_;
NVL : N_ V_ L_ ;
ON : O_ N_ ;
ONLY : O_ N_ L_ Y_;
OPTIMIZE : O_ P_ T_ I_ M_ I_ Z_ E_ ;
OR : O_ R_ ;
ORDER : O_ R_ D_ E_ R_;
OUTER : O_ U_ T_ E_ R_;
OVER : O_ V_ E_ R_;
PARTITION : P_ A_ R_ T_ I_ T_ I_ O_ N_;
PRIOR : P_ R_ I_ O_ R_;
RANK : R_ A_ N_ K_;
READ : R_ E_ A_ D_ ;
ROW : R_ O_ W_ ;
ROWS : R_ O_ W_ S_;
RIGHT : R_ I_ G_ H_ T_; 
SECOND : S_ E_ C_ O_ N_ D_;
SELECT : S_ E_ L_ E_ C_ T_;
SET : S_ E_ T_ ;
SOME : S_ O_ M_ E_;
START : S_ T_ A_ R_ T_ ;
SUBSTRING : S_ U_ B_ S_ T_ R_ I_ N_ G_;
SUM : S_ U_ M_ ;
SYSDATE : S_ Y_ S_ D_ A_ T_ E_;
TABLE : T_ A_ B_ L_ E_;
THEN : T_ H_ E_ N_;
TIME : T_ I_ M_ E_;
TIMESTAMP: T_ I_ M_ E_ S_ T_ A_ M_ P_ ;
UNION : U_ N_ I_ O_ N_ ;
UPDATE : U_ P_ D_ A_ T_ E_ ;
UR : U_ R_; 
USING : U_ S_ I_ N_ G_;
VALUE : V_ A_ L_ U_ E_ ; 
VALUES : V_ A_ L_ U_ E_ S_ ;
WHEN : W_ H_ E_ N_ ;
WHERE : W_ H_ E_ R_ E_ ;
WITH  : W_ I_ T_ H_ ;
YEAR : Y_ E_ A_ R_ ;
YEARS : Y_ E_ A_ R_ S_ ;

DOT_STAR: '.*' ;
DOT : '.' ;
COMMA : ',' ;
LPAREN : '(' ;
RPAREN : ')' ;

UNDERSCOPE : '_'; 
DASH : '-' ;
COLON : ':' ;
SEMICOLON : ';';

ASSIGNEQUAL : '=' ;
NOTEQUAL1 : '<>' ;
NOTEQUAL2 : '!=' ;
LESSTHANOREQUALTO1 : '<=' ;
LESSTHAN : '<' ;
GREATERTHANOREQUALTO1 : '>=' ;
GREATERTHAN : '>' ;

DIVIDE : '/' ;
PLUS : '+' ;
STAR : '*' ;
MOD : '%' ;

STRCONCAT : '||' ;

PLACEHOLDER: '?' ;

fragment
Letter : 'a'..'z'|'A'..'Z'|'\u3131'..'\u318E'|'\uAC00'..'\uD7A3'|'@' ;

fragment
Digit : '0'..'9' ;

fragment
Integer :;

fragment
Real :;

fragment
Exponent :
  'e' ( '+' | '-' )? (Digit)+
  ;
  
fragment A_ : 'A' | 'a';
fragment B_ : 'B' | 'b';
fragment C_ : 'C' | 'c';
fragment D_ : 'D' | 'd';
fragment E_ : 'E' | 'e';
fragment F_ : 'F' | 'f';
fragment G_ : 'G' | 'g';
fragment H_ : 'H' | 'h';
fragment I_ : 'I' | 'i';
fragment J_ : 'J' | 'j';
fragment K_ : 'K' | 'k';
fragment L_ : 'L' | 'l';
fragment M_ : 'M' | 'm';
fragment N_ : 'N' | 'n';
fragment O_ : 'O' | 'o';
fragment P_ : 'P' | 'p';
fragment Q_ : 'Q' | 'q';
fragment R_ : 'R' | 'r';
fragment S_ : 'S' | 's';
fragment T_ : 'T' | 't';
fragment U_ : 'U' | 'u';
fragment V_ : 'V' | 'v';
fragment W_ : 'W' | 'w';
fragment X_ : 'X' | 'x';
fragment Y_ : 'Y' | 'y';
fragment Z_ : 'Z' | 'z';
fragment UNDER_ : '_';

MAccessDateTime :
  '#' Digit Digit Digit Digit '-'
    Digit Digit '-' Digit Digit ' '
    Digit Digit ':' Digit Digit ':' Digit Digit
    '#'
  ;

Iso8601DateTime :
  Digit Digit Digit Digit '-'
    Digit Digit '-' Digit Digit ( 't' | ' ' )
    Digit Digit ':' Digit Digit ':' Digit Digit
  ;

Number :
  ( (Digit)+ ('.' | 'e') ) => (Digit)+ ( '.' (Digit)* (Exponent)? | Exponent) { $type = Real; }
  | '.' { $type = DOT; } ( (Digit)+ (Exponent)? { $type = Real; } )?
  | (Digit)+ { $type = Integer; }
  | '0x' ('a'..'f' | Digit)* { $type = HexLiteral; } // "0x" is valid hex literal
  ;

fragment
WordTail :
  (Letter | Digit | UNDERSCOPE | COLON )*
  ;

NonQuotedIdentifier : Letter WordTail ;

QuotedIdentifier :
  '[' (~']')* ']' (']' (~']')* ']')*
  | '"' (~'"')* '"' ('"' (~'"')* '"')* // SQL 92 <delimited identifier>
  | '`' (~'`')* '`' 
   // MS Access; not sure whether the identifier
        // can contain doubled backquotes (and
        // doubtful that it would be desirable
        // in the first place), so playing it
        // safe & not allowing them
    ;

// Note that after the first char, it's the same as in
// NonQuotedIdentifier - some application code relies on that, i.e. when
// generating parameter names.
Variable :
  ( '@' | ':' ) Letter WordTail
  ;

fragment
AsciiStringRun :
  // single-line literals only
  ( '\t' | ' ' .. '&' | '(' .. '~' )+
  ;

AsciiStringLiteral :
  '\'' 
  ( s = AsciiStringRun  )? '\''
  ( '\'' ( s = AsciiStringRun  )? '\''
  )*
  ;

//fragment
//UnicodeStringRun :
//  (~ '\'' )+
//  ;

//UnicodeStringLiteral :
//  '\'' 
//  ( s = UnicodeStringRun  )? '\''
//  ( '\'' 
//    ( s = UnicodeStringRun  )? '\''
//    )*
//;

// \u0022 : " , \u005C : \ , \u0027 : '
fragment
UnicodeStringRun : ~('\u0022' | '\u005C' |'\u0027')
    ;
    
fragment
UnicodeStringValue : ~('\u0023' | '\u0024') ;

UicodeValueLiteral :
  ( '#' | '$' ) UnicodeStringValue+ ( '#' | '$' );
  
fragment
UnicodeColumnValue : ~('\u0023' | '\u0024' | '\u002E');

UnicodeStringLiteral :  
  '\'' UnicodeStringRun+ '\'' ;
    
fragment
HexLiteral : // generated as a part of Number rule
  // '0x' ('0'..'9' | 'a'..'f')*
  ;
  
SingleLineComment
 : '--' ~('\r' | '\n')* {skip();}
 ;
 
MultiLineComment
 : '/*' .* '*/' {skip();}
 ;
 
MultiLineComment2
 : '<!--' .* '-->' {skip();}
 ;

Whitespace : ( '\t' | ' ' | '\r' | '\n' )+  { $channel=HIDDEN; }
  ;