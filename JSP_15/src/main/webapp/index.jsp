<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP_15</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
      <input  onkeydown="Change()" type="text" name="input" id="id_input" placeholder="input your name" />
      <p id="id_output">Output: </p>
      <p>=====================</p>
      <div id="my_div">
        ORIGIN THINGS
      </div>
      <input onclick="clickChange()" type="button" id="button1" value="click" />
      <p>=====================</p>
      <div onmouseover="hoverOn()" onmouseout="hoverOff()" id="my_div2" style="background-color: yellow;">
        fjasldjkldjgls <hr/>
        fjasldjkldjgls <hr/>
        fjasldjkldjgls <hr/>
      </div>
      <p>=====================</p>
      <div  id="my_div3">
        JFLAKDGGSLKJGSKLGJS
      </div>
      <input onclick="displayOnOff()" onclick="displayOff()" type="button" name="" id="" value="show/hide" />
      <p>=====================</p>
      <div class="container">
        <form id="my_form">
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1">
          </div>
          <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
          </div>
          <button onclick="checkSubmit()" id="submit_btn" type="button" class="btn btn-primary">Submit</button>
        </form>
      </div>
      
      <script>
        var input =  document.getElementById("id_input");
        var output = document.getElementById("id_output");
        function Change(){
          output.innerHTML = "xin chao "+ input.value;
        }
        //=======
        var my_div = document.getElementById("my_div");
        function clickChange(){
          my_div.innerHTML = "CHANGED THINGS!!!";
        }
        //=======
        var my_div2 = document.getElementById("my_div2");
        function hoverOn(){
          my_div2.style = "background-color: green;"
        }
        function hoverOff(){
          my_div2.style = "background-color: yellow;"
        }
        //=======
        var my_div3 = document.getElementById("my_div3");
        var check = "hidden";
        function displayOnOff(){
          if(check=="hidden"){
            my_div3.style = "display: none;";
            check = "show";
          } else if(check=="show"){
            my_div3.style = "display: block;"
            check= "hidden";
          }
        }
        //=======
        function checkSubmit(){
          var email_input = document.getElementById("exampleInputEmail1");
          var password_input = document.getElementById("exampleInputPassword1");
          var email = email_input.value;
          var password = password_input.value;
          
          if(email.length <= 0 || password.length <= 0){
            alert("Please input infomation");
          } else {
            var form = document.getElementById("my_form");
            form.onsubmit();
          }
        }
      </script>
  </body>
</html>