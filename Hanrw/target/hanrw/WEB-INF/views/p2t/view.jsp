<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--이미지갤러리-->
<div class="board">
    <div class="board-box-img">
        <div class="big-img">
            <a href="<c:out value='${pageContext.request.contextPath}'/>/static/img/sample/p2t_sample.jpg" target="_blank"><img src="<c:out value='${pageContext.request.contextPath}'/>/static/img/sample/p2t_sample.jpg"/></a>
        </div>
        <div class="img-list">
            <div class="arrow-left"><a href="">&#8249;</a></div>
            <div class="small-imgs">
                <li><a href="#"><img src="<c:out value='${pageContext.request.contextPath}'/>/static/img/sample/p2t_sample.jpg"/></a></li>
                <li><a href="#"><img src="<c:out value='${pageContext.request.contextPath}'/>/static/img/sample/p2t_sample.jpg"/></a></li>
                <li><a href="#"><img src="<c:out value='${pageContext.request.contextPath}'/>/static/img/sample/p2t_sample.jpg"/></a></li>
                <li><!--<a href=""><img src="images/testimg01.jpg"/></a>--></li>
                <li><!--<a href=""><img src="images/testimg01.jpg"/></a>--></li>
                <li><!--<a href=""><img src="images/testimg01.jpg"/></a>--></li>
                <li><!--<a href=""><img src="images/testimg01.jpg"/></a>--></li>
            </div>
            <div class="arrow-right"><a href="">&#8250;</a></div>
        </div>
    </div>
</div>
<!--텍스트창-->
<div class="text-input">
    <textarea name="text-change" id="text-change" cols="1" rows="">전자책(e-book)이 과연 종이책을 밀어낼까. 밀어낸다면 그 시점은 언제가 될까. 이런 질문에 대해 "전자책은 결코 종이책을 밀어내지 못할 것"이라고 주장하는 사람도 있다. 그러나 세계 최대 출판시장인 미국을 보면 전자책의 약진과 종이책의 완연한 퇴조가 나타나고 있다.

        미국출판협회에 따르면 미국 전자책 판매 실적은 지난 2월 9030만달러로 1년 전의 3배 이상에 달했다. 지난해 1분기 전체 판매실적(9100만달러)과도 비슷하다. 이런 추세라면 지금쯤 월 1억달러를 돌파했을 게 확실해 보인다. 전자책 판매는 이미 가파른 상승국면인 '티핑 포인트'에 진입했다는 얘기도 나온다.

        ◆전자책 강점 갈수록 두드러져

        미국에서 전자책시장이 급성장한 것은 아마존 이리더(e-reader,전자책 단말기) 킨들(사진) 덕분이다. 킨들은 2007년 말 첫 발매 때 가격이 399달러(와이파이 모델)로 꽤 부담스러웠으나 지난해 4월 아이패드 발매 후 139달러까지 떨어졌다. 아마존은 킨들 판매대수를 밝힌 적이 없지만 포리스터리서치는 600만대쯤 팔렸고 이리더시장 3분의 2를 차지했을 것으로 추산했다.

        애플이 아이패드를 발매하고 아마존이 아이패드용 킨들 앱(응용 프로그램)을 내놓은 것도 전자책 판매 급증 원인으로 꼽힌다. 아마존은 전자책 95만종을 확보하고 있고,뉴욕타임스 베스트셀러 111종 가운데 107종을 전자책으로 판매하고 있다. 오는 11월21일 발매되는 스티브 잡스의 전기도 하드커버는 17.88달러,전자책은 16.99달러에 예약 판매하고 있다.

        전자책 판매가 급증하는 만큼 종이책 판매는 줄고 있다. 올해 1~2월 전자책 판매는 1억6410만달러로 작년 같은 기간에 비해 170% 증가한 반면 종이책 판매는 4억4170만달러로 24.8% 감소했다. 벤처비트라는 매체는 종이책의 전자책화가 가속화될 것인 만큼 종이책 매출의 회복세를 기대하기 어렵다고 예상했다.

        전자책이 종이책을 밀어내고 있는 것은 제작비 유통비 등이 적게 드는 데다 단말기 성능은 더욱 좋아지고 있기 때문이다. 구매 클릭 후 30초 이내에 책을 내려받을 수 있고 주문한 뒤 오랜 시간을 기다릴 필요가 없다. 유통비는 제로이고,가격도 종이책보다 저렴하다. 시장이 국내에 한정되지 않고 전 세계라는 점도 강점이다.

        ◆한국도 예외 아니다

        전자책이 보편화되면 '자기출판(self-publishing)'도 가능해진다. 저자가 플랫폼(인터넷 유통 사업자)을 통해 직접 소비자에게 판매하면 오프라인 서점 등 중간유통상과 출판사들이 설 자리를 잃게 된다. 정보기술(IT) 분야 블로거인 제프 불라스는 "블로그 독자 10만명,트위터 팔로어 5만명,페이스북 팬 2만명만 확보하면 전통적인 유통 채널이 없어도 된다"고 말했다.


        미국 출판업계에서는 이미 시장이 바뀌는 '마켓 시프트(market shift)'가 진행되고 있다. 불라스는 "구텐베르크가 인쇄술을 발명한 후 가장 큰 변화가 일어나고 있다"며 "종이책이 언젠가는 선물용으로 전락할 것"이라고 예상했다. 또 "미국에서는 전자책을 팔아 연간 100만달러(11억원)를 벌어들인 작가도 있다"며 "인터넷 세대가 앞으로 어떤 방식으로 책을 읽겠느냐"고 반문했다.

        물론 미국과 한국은 다르다. 미국에 비하면 적어도 3년은 뒤져 있다. 아마존이 킨들을 발매한 후 교보문고 인터파크 등이 경쟁적으로 전자책 단말기를 내놓았지만 성공하지는 못했다. 값이 비싸고 사용하기 불편하며 콘텐츠가 부족했기 때문이다. 그러나 이런 문제는 시간이 좀 걸릴 뿐,언젠가는 해결될 것으로 보인다.</textarea>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="view-list" id="view-list" value="목록" />
        <input type="button" name="do" id="do" value="작업" />
        <input type="button" name="delete" id="delete" value="삭제" />
    </form>
</div>