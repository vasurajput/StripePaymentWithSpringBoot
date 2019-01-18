<%-- 
    Document   : index
    Created on : 18 Jan, 2019, 11:42:41 AM
    Author     : rv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stripe Custom CheckOut</title>
        <script src="https://checkout.stripe.com/checkout.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <style>
            #customButton{

                background: #444 none repeat scroll 0 0;
                border: 1px solid #444;
                color: #fff;
                margin-bottom: 25px;
                padding: 10px 35px;
                text-transform: uppercase;
                transition: all 0.4s ease 0s;
                border-radius: 30px;
                cursor:pointer;
            }

        </style>
    </head>
    <body>
        <h4>Stripe Custom CheckOut</h4>
        <button id="customButton">Buy Me</button>

        <script>
            var handler = StripeCheckout.configure({
                key: 'Your public key comes here',
                image: 'https://stripe.com/img/documentation/checkout/marketplace.png',
                locale: 'auto',
                token: function (token) {
                    console.log("Token Success REsult");
                    console.log(token);
                    console.log("token id is");
                    console.log(token.id)
                    $.ajax({
                        type: "POST",
                        url: "chargePayment",
                        data: token.id, // serializes the form's elements.
                        success: function (data)
                        {
                            alert(data); // show response from the php script.
                        }
                    });
                }
            });

            document.getElementById('customButton').addEventListener('click', function (e) {
                // Open Checkout with further options:
                handler.open({
                    name: 'Vasu Rajput Purchasing',
                    description: 'Basic Plan',
                    amount: 3000
                });
                e.preventDefault();
            });

// Close Checkout on page navigation:
            window.addEventListener('popstate', function () {
                handler.close();
            });
        </script>
    </body>
</html>
