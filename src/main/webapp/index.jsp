<!DOCTYPE html>
<html>
<head>
    <title>Trek Roulette</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="styles/stars.css">
</head>
<body>
<div class="bg">
    <div class="z-3">
        <div class="tile top-left animate-opacity freq-5"></div>
        <div class="tile top-right animate-opacity freq-9"></div>
        <div class="tile bottom-left animate-opacity freq-7"></div>
        <div class="tile bottom-right animate-opacity freq-10"></div>
    </div>
    <div class="z-2">
        <div class="tile top-left animate-opacity freq-9 delay-2"></div>
        <div class="tile top-right animate-opacity freq-5 delay-2"></div>
        <div class="tile bottom-left animate-opacity freq-6 delay-4"></div>
        <div class="tile bottom-right animate-opacity freq-10 delay-4"></div>
    </div>
    <div class="z-1">
        <div class="tile top-left animate-opacity freq-7 delay-2"></div>
        <div class="tile top-right animate-opacity freq-5 delay-4"></div>
        <div class="tile bottom-left animate-opacity freq-9 delay-2"></div>
        <div class="tile bottom-right animate-opacity freq-5 delay"></div>
    </div>
</div>
<div class="w3-display-container w3-text-white">
    <div class="w3-display-topleft w3-container w3-xlarge">
        <p><button onclick="document.getElementById('access').style.display='block'" class="w3-button w3-black">Authenticate</button></p>
        <p><button onclick="document.getElementById('spin').style.display='block'" class="w3-button w3-black">Give it a spin</button></p>
        <p><button onclick="document.getElementById('about').style.display='block'" class="w3-button w3-black">About Trek Roulette</button></p>
    </div>
    <div class="w3-display-bottomleft w3-container">
        <p class="w3-xlarge">Want to watch some Star Trek, but don't want to choose?</p>
        <p class="w3-large"><strong>Trek Roulette</strong> is here to help!</p>
        <p>powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div>
</div>
<!-- Access Modal -->
<div id="access" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black w3-display-container">
            <span onclick="document.getElementById('access').style.display='none'" class="w3-button w3-display-topright w3-large">x</span>
            <h1>Starters</h1>
        </div>
        <div class="w3-container">
            <h5>Tomato Soup <b>$2.50</b></h5>
            <h5>Chicken Salad <b>$3.50</b></h5>
            <h5>Bread and Butter <b>$1.00</b></h5>
        </div>
        <div class="w3-container w3-black">
            <h1>Main Courses</h1>
        </div>
        <div class="w3-container">
            <h5>Grilled Fish and Potatoes <b>$8.50</b></h5>
            <h5>Italian Pizza <b>$5.50</b></h5>
            <h5>Veggie Pasta <b>$4.00</b></h5>
            <h5>Chicken and Potatoes <b>$6.50</b></h5>
            <h5>Deluxe Burger <b>$5.00</b></h5>
        </div>
        <div class="w3-container w3-black">
            <h1>Desserts</h1>
        </div>
        <div class="w3-container">
            <h5>Fruit Salad <b>$2.50</b></h5>
            <h5>Ice cream <b>$2.00</b></h5>
            <h5>Chocolate Cake <b>$4.00</b></h5>
            <h5>Cheese <b>$5.50</b></h5>
        </div>
    </div>
</div>

<!-- Spin Modal -->
<div id="spin" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black w3-display-container">
            <span onclick="document.getElementById('spin').style.display='none'" class="w3-button w3-display-topright w3-large">x</span>
            <h1>Starters</h1>
        </div>
        <div class="w3-container">
            <h5>Tomato Soup <b>$2.50</b></h5>
            <h5>Chicken Salad <b>$3.50</b></h5>
            <h5>Bread and Butter <b>$1.00</b></h5>
        </div>
        <div class="w3-container w3-black">
            <h1>Main Courses</h1>
        </div>
        <div class="w3-container">
            <h5>Grilled Fish and Potatoes <b>$8.50</b></h5>
            <h5>Italian Pizza <b>$5.50</b></h5>
            <h5>Veggie Pasta <b>$4.00</b></h5>
            <h5>Chicken and Potatoes <b>$6.50</b></h5>
            <h5>Deluxe Burger <b>$5.00</b></h5>
        </div>
        <div class="w3-container w3-black">
            <h1>Desserts</h1>
        </div>
        <div class="w3-container">
            <h5>Fruit Salad <b>$2.50</b></h5>
            <h5>Ice cream <b>$2.00</b></h5>
            <h5>Chocolate Cake <b>$4.00</b></h5>
            <h5>Cheese <b>$5.50</b></h5>
        </div>
    </div>
</div>

<!-- About Modal -->
<div id="about" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <div class="w3-container w3-black">
            <span onclick="document.getElementById('about').style.display='none'" class="w3-button w3-display-topright w3-large">x</span>
            <h1>Contact</h1>
        </div>
        <div class="w3-container">
            <p>Reserve a table, ask for today's special or just send us a message:</p>
            <form action="/action_page.php" target="_blank">
                <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Name" required name="Name"></p>
                <p><input class="w3-input w3-padding-16 w3-border" type="number" placeholder="How many people" required name="People"></p>
                <p><input class="w3-input w3-padding-16 w3-border" type="datetime-local" placeholder="Date and time" required name="date" value="2020-11-16T20:00"></p>
                <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Message \ Special requirements" required name="Message"></p>
                <p><button class="w3-button" type="submit">SEND MESSAGE</button></p>
            </form>
        </div>
    </div>
</div>

</body>
<script src="js/stars.js"></script>
</html>

