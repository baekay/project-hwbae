
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>WEB restAPI Explorer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="yhlee">

    <!-- Le styles -->
    <link href="../static/css/bootstrap.css" rel="stylesheet">
    <link href="../static/css/testbed.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
    <link href="../static/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../static/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../static/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../static/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../static/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">hanrw</a>
          <div class="nav-collapse collapse">
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h1>WEB restAPI Explorer</h1>
      <p>Use this document as a way to test WEB restAPI<br></p>
      <table style="width:100%;" class="table table-bordered">
      	<thead>
      		<tr> 
      			<th style="text-align:center;">Request</th>
      			<th style="text-align:center;">Response</th>
      		</tr>
      	</thead>
      	<tbody>
      		<tr>
      			<td width="50%">
      				<form class="form-horizontal" id="testform">
      					<div class="control-group">
      						<label class="control-label" for="inputUrl">Access Token</label>
      						<div class="controls">
      							<input type="text" id="accessToken" class="input-xlarge">
      						</div>
      					</div>
      					<div class="control-group">
      						<label class="control-label" for="inputUrl">API URL</label>
      						<div class="controls">
      							<input type="text" id="reqUrl" value="http://localhost:8080/hanrw/" class="input-xlarge" placeholder="http://localhost:8080/hanrw/app/user/regist">
      						</div>
      					</div>
      					<div class="control-group">
      						<label class="control-label" for="inputUrl">Method</label>
      						<div class="controls">
      							<select id="reqMethod">
      								<option>GET</option>
      								<option>POST</option>
      							</select>
      						</div>
      					</div>
      					<div class="control-group">
      						<label class="control-label" for="inputUrl">message</label>
      						<div class="controls">
      							<textarea rows="12" id="sendMessage"  class="input-xlarge"></textarea>
      						</div>
      					</div>
      					<div class="control-group">
      						<div class="controls">
      							<button class="btn btn-primary" id="sendBtn" type="button">Send Request</button>
      						</div>
      					</div>
      				</form>
      			</td>
      			<td width="50%">
      				<form class="form-horizontal">
	      				<div class="control-group">
	   						<label class="control-label" for="inputUrl">Http Status Code</label>
	   						<div class="controls">
	   							<input type="text" id="statusCode" class="input-small" readonly>
	   						</div>
	   					</div>
	   					<div class="control-group">
      						<label class="control-label" for="inputUrl">Response Message</label>
      						<div class="controls">
      							<textarea rows="12" id="responseMessage" class="input-xlarge"></textarea>
      						</div>
      					</div>
      				</form>
      			</td>
      		</tr>
      	</tbody>
      </table>
    </div> <!-- /container -->
    
    
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.8.2.js"></script>  
    <script src="../static/js/hanrw-testform.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <!-- 
    <script src="../static/js/bootstrap-alert.js"></script>
    <script src="../static/js/bootstrap-modal.js"></script>
    <script src="../static/js/bootstrap-dropdown.js"></script>
    <script src="../static/js/bootstrap-scrollspy.js"></script>
    <script src="../static/js/bootstrap-tab.js"></script>
    <script src="../static/js/bootstrap-tooltip.js"></script>
    <script src="../static/js/bootstrap-popover.js"></script>
    <script src="../static/js/bootstrap-button.js"></script>
    <script src="../static/js/bootstrap-collapse.js"></script>
    <script src="../static/js/bootstrap-carousel.js"></script>
    <script src="../static/js/bootstrap-typeahead.js"></script>
    -->

  </body>
</html>
