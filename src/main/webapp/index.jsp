<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Home Page</title>

<style>
body {
    margin: 0;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: Arial, sans-serif;
    transition: 0.5s;
    overflow: hidden;
}

/* Animated gradient background */
body.light {
    background: linear-gradient(270deg,#ff6ec4,#7873f5,#42e695,#fddb92);
    background-size: 800% 800%;
    animation: gradientMove 12s ease infinite;
}

body.dark {
    background: linear-gradient(270deg,#141e30,#243b55,#000000);
    background-size: 600% 600%;
    animation: gradientMove 12s ease infinite;
}

@keyframes gradientMove {
    0% {background-position:0% 50%;}
    50% {background-position:100% 50%;}
    100% {background-position:0% 50%;}
}

/* Floating bubbles */
.bubble {
    position: absolute;
    bottom: -100px;
    background: rgba(255,255,255,0.2);
    border-radius: 50%;
    animation: floatUp linear infinite;
}

@keyframes floatUp {
    from {transform: translateY(0);}
    to {transform: translateY(-110vh);}
}

/* Center box */
.container {
    text-align: center;
    background: rgba(255,255,255,0.15);
    padding: 50px;
    border-radius: 20px;
    backdrop-filter: blur(12px);
    box-shadow: 0 10px 30px rgba(0,0,0,0.2);
    color: white;
    z-index: 1;
}

/* Title */
h1 {
    margin-bottom: 40px;
}

/* Buttons */
.button {
    display: inline-block;
    margin: 10px;
    padding: 15px 40px;
    font-size: 18px;
    color: white;
    border-radius: 30px;
    text-decoration: none;
    background: linear-gradient(45deg,#ff512f,#dd2476);
    transition: 0.3s;
}

.button:hover {
    transform: scale(1.1);
    box-shadow: 0 10px 25px rgba(0,0,0,0.3);
}

/* Dark mode toggle */
.toggle {
    position: absolute;
    top: 20px;
    right: 20px;
    padding: 10px 15px;
    border: none;
    border-radius: 20px;
    cursor: pointer;
}

/* Mobile responsive */
@media(max-width:600px){
    .container {
        width: 85%;
        padding: 30px;
    }
}
</style>
</head>

<body class="light">

<button class="toggle" onclick="toggleMode()">Mode</button>

<div class="container">
    <h1>Welcome</h1>

    <a href="register.html" class="button">Register</a>
    <a href="login.html" class="button">Login</a>
</div>

<!-- Floating bubbles -->
<script>
for(let i=0;i<15;i++){
    let bubble=document.createElement("div");
    bubble.className="bubble";
    bubble.style.width=Math.random()*40+20+"px";
    bubble.style.height=bubble.style.width;
    bubble.style.left=Math.random()*100+"%";
    bubble.style.animationDuration=Math.random()*10+10+"s";
    document.body.appendChild(bubble);
}

function toggleMode(){
    document.body.classList.toggle("dark");
    document.body.classList.toggle("light");
}
</script>

</body>
</html>
