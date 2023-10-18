<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>

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
                                <a href="login.html">Login Form</a>
                            </li>

                            <li>
                                <a class="active" href="register.html">Create an account</a>
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

                        <div class="col-lg-6 col-12 mx-auto">
                            <form class="custom-form" role="form" method="post" action="./regist">
                                <h2 class="hero-title text-center mb-4 pb-2">Create an account</h2>

                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="text" name="username" id="username" class="form-control" placeholder="username" required="">
                                   
                                            <label for="floatingInput">username</label>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="text" name="Gender" id="Gender" class="form-control" placeholder="Gender" required="">

                                            <label for="floatingInput">Gender</label>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="text" name="Age" id="Age" class="form-control" placeholder="Age" required="">
                                            <label for="floatingInput">Age</label>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="text" name="Tel" id="Tel" class="form-control" placeholder="Tel" required="">
                                            <label for="floatingInput">Tel</label>
                                        </div>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating mb-4 p-0">
                                            <input type="Email" name="Email" id="Email" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="Email" required=""
                                            oninvalid="setCustomValidity('Please include @ in your email address!');" oninput="setCustomValidity('');">

                                            <label for="Email">Email</label>
                                        </div>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="password" name="password" id="password" class="form-control" placeholder="password" required="">

                                            <label for="password">password</label>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-6 col-md-6 col-12">
                                        <div class="form-floating">
                                            <input type="passwordagain" name="passwordagain" id="passwordagain" class="form-control" placeholder="password again" required="">

                                            <label for="passwordagain">password again</label>
                                        </div>
                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-lg-5 col-md-5 col-5 ms-auto">
                                            <button type="submit" class="form-control">Submit</button>
                                        </div>

                                        <div class="col-lg-6 col-md-6 col-12">
                                          <div class="row justify-content-center align-items-center">
                                            <p class="mb-0">Already have an account? <a href="login.jsp" class="ms-2">Login</a></p>
                                        </div>
                                        </div>
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
