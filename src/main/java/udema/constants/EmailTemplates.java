package udema.constants;

public class EmailTemplates {
	public static final String CSS =
		".code {" +
			"width: 170px;"+
			"background-color: #f2f2f2;"+
			"padding: 10px 0px;"+
        "}"+
        ".code-number {"+
        	"font-weight: bold;"+
        	"letter-spacing: 5px;"+
        	"font-family: Helvetica Neue, Helvetica, Lucida Grande, tahoma, verdana, arial, sans-serif;"+
        	"font-size: 22px;"+
        	"line-height: 21px;"+
        	"display: block;"+
        	"text-align: center;"+
        	"}"+
        ".font-style {"+
        	"font-family: Helvetica Neue, Helvetica, Lucida Grande, tahoma, verdana, arial, sans-serif;"+
        	"line-height: 21px;"+
        	"font-size: 16px;"+
        "}"+
        ".link {"+
	      	"width: 100px;"+
	      	"background-color: #f2f2f2;"+
	      	"border-radius: 2px;"+
	      	"padding: 5px 0px;"+
	      	"border-radius: 5px;"+
        	"}"+
        ".a {"+
            "text-decoration: none;"+
            "display: block;"+
            "text-align: center;"+
            "color: black;"+
            "}"+
	    ".link:hover {"+
	        "background-color: rgb(98, 209, 209);"+
	        "}"+
        ".color {"+
	        "color: blue;"+
	        "}";
	public static final String REGISTER_TEMPLATE = 
		"<!DOCTYPE html>"+
        "<html lang='en'>"+
        "<head>"+
        "<meta charset='UTF-8'>"+
        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
        "<title>Document</title>"+
        "<style>"+
         CSS +
        "</style>"+
        "</head>"+
        "<body>"+
        "<div class='body'>"+
            "<div class='content'>"+
            "<div>"+
                "<span class='font-style' style='font-size: 18px; font-weight: bold;'>Your Udema security code</span>"+
            "</div>"+
            "<br>"+
            "<div>"+
                "<span class='font-style'>Hi Son,</span>"+
            "</div>"+
            "<br>"+
            "<div>"+
                "<span class='font-style'>Your security code is:</span>"+
            "</div>"+
            "<br>"+
            "<div class='code'>"+
                "<span class='code-number'>740293</span>"+
            "</div>"+
            "<br>"+
            "<div>"+
                "<span class='font-style'>To help us confirm your identity on Udema, we need to verify your"+
                "email address. Paste this code into"+
                "your browser.</span>"+
            "</div>"+
            "<div>"+
                "<span class='font-style'>It can only be used once.</span>"+
            "</div>"+
            "<br><br>"+
            "<div>"+
                "<span class='font-style'>Thanks,</span>"+
            "</div>"+
            "<div>"+
                "<span class='font-style'>The Udema Security Team</span>"+
            "</div>"+	
            "<div>"+
            "</div>"+
        "</body>"+
        "</html>";
	public static final String FORGOT_TEMPLATE =
	        "<!DOCTYPE html>"+
	        "<html lang='en'>"+
	        "<head>"+
	        "<meta charset='UTF-8'>"+
	        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
	        "<title>Document</title>"+
	        "<style>"+
	         CSS +
	        "</style>"+
	        "</head>"+
	        "<body>"+
	        "<div class='body'>"+
	            "<div class='content'>"+
	            "<div>"+
	                "<span class='font-style' style='font-size: 18px; font-weight: bold;'>Your Udema security code</span>"+
	            "</div>"+
	            "<br>"+
	            "<div>"+
	                "<span class='font-style'>Hi Son,</span>"+
	            "</div>"+
	            "<br>"+
	            "<div>"+
	                "<span class='font-style'>Click the button bellow to active</span>"+
	            "</div>"+
	            "<br>"+
	            "<div class='link'>"+
	                "<a href='https://codelearn.io/sharing/graphql-va-uu-diem-so-voi-rest-api' class='a font-style'>Click here</a>"+
	            "</div>"+
	            "<br>"+
	            "<div>"+
	            "<span class='font-style'>or use the link bellow to go to page </span>"+
	            "</div>"+
	            "<br>"+
	            "<div>"+
	            "<a href='https://codelearn.io/sharing/graphql-va-uu-diem-so-voi-rest-api' class='font-style color'>https://codelearn.io/sharing/graphql-va-uu-diem-so-voi-rest-api</a>"+
	            "</div>"+
	            "<br>"+
	            "<div>"+
	                "<span class='font-style'>To help us confirm your identity on Udema, we need to verify your"+
	                "email address. Paste this code into"+
	                "your browser.</span>"+
	            "</div>"+
	            "<div>"+
	                "<span class='font-style'>It can only be used once.</span>"+
	            "</div>"+
	            "<br><br>"+
	            "<div>"+
	                "<span class='font-style'>Thanks,</span>"+
	            "</div>"+
	            "<div>"+
	                "<span class='font-style'>The Udema Security Team</span>"+
	            "</div>"+
	            "<div>"+
	            "</div>"+
	        "</body>"+
	        "</html>";
}