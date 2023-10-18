<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Kool Form Pack | Login page</title>

        <!-- CSS FILES -->                
        <link rel="preconnect" href="https://fonts.googleapis.com">
        
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,200;0,400;0,700;1,200&family=Unbounded:wght@400;700&display=swap" rel="stylesheet">
        
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/tooplate-kool-form-pack.css" rel="stylesheet">
<!--

Tooplate 2136 Kool Form Pack

https://www.tooplate.com/view/2136-kool-form-pack

Bootstrap 5 Form Pack Template

-->
    </head>
    
    <body>

        <main>

            


            <div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasMenu" aria-labelledby="offcanvasMenuLabel">                
                <div class="offcanvas-header">                    
                    <button type="button" class="btn-close ms-auto" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                
                <div class="offcanvas-body d-flex flex-column justify-content-center align-items-center">
                    <nav>
                        <ul>
                            <li>
                                <a class="active" href="login.html">Login Form</a>
                            </li>

                            <li>
                                <a href="register.html">Create an account</a>
                            </li>

                            <li>
                                <a href="password-reset.html">Password Reset</a>
                            </li>

                            <li>
                                <a href="404.html">404 Page</a>
                            </li>

                            <li>
                                <a href="contact.html">Contact Form</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="subscribeModal" tabindex="-1" aria-labelledby="subscribeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">
                            <form action="#" method="get" class="custom-form mt-lg-4 mt-2" role="form">
                                <h2 class="modal-title" id="subscribeModalLabel">Stay up to date</h2>

                                <input type="email" name="email" id="email" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="your@email.com" required="">

                                <button type="submit" class="form-control">Notify</button>
                            </form>
                        </div>

                        <div class="modal-footer justify-content-center">
                            <p>By signing up, you agree to our Privacy Notice</p>
                        </div>
                    </div>
                </div>
            </div>


            <section class="hero-section d-flex justify-content-center align-items-center">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-5 col-12 mx-auto">
                            <form class="custom-form login-form" role="form" method="post" action="./login">
                                <h2 class="hero-title text-center mb-4 pb-2">Login Form</h2>

                                <div class="form-floating mb-4 p-0">
                                    <input type="text" name="username" id="username"class="form-control" placeholder="username" required="">

                                    <label for="username">username</label>
                                </div>

                                <div class="form-floating p-0">
                                    <input type="password" name="password" id="password" class="form-control" placeholder="password" required="">

                                    <label for="password">Password</label>
                                </div>

                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                  
                                    <label class="form-check-label" for="flexCheckDefault">
                                        Remember me
                                    </label>
                                </div>

                                <div class="row justify-content-center align-items-center">
                                    <div class="col-lg-5 col-12">
                                        <button type="submit" class="form-control">Login</button>
                                    </div>

                                    <div class="col-lg-5 col-12">
                                        <a href="register.jsp" class="btn custom-btn custom-border-btn">Register</a>
                                    </div>
                                </div>

                            </form>
                            
                        </div>
                    </div>
                </div>

                <div class="video-wrap">
                    <video autoplay="" loop="" muted="" class="custom-video" poster="">
                        <source src="videos/video.mp4" type="video/mp4">

                        Your browser does not support the video tag.
                    </video>
                </div>
            </section>
        </main>

        <!-- JAVASCRIPT FILES -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/countdown.js"></script>
        <script src="js/init.js"></script>

    </body>
</html>