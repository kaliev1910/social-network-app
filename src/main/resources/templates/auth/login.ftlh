<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-light" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                            <p class="text-dark mb-5">Please enter your login and password!</p>

                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="email" id="typeEmailX"  name="username" class="form-control form-control-lg" />
                                <label class="form-label" for="typeEmailX">Email</label>
                            </div>

                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="password" id="typePasswordX"  name="password" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordX">Password</label>
                            </div>

                            <p class="small mb-5 pb-lg-2"><a class="text-dark" href="#!">Forgot password?</a></p>

                            <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-dark btn-lg px-5"
                                    type="submit">Login</button>

                            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                <a href="#!" class="text-dark"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-dark"><i class="fab fa-google fa-lg"></i></a>
                            </div>

                        </div>

                        <div>
                            <p class="mb-0">Don't have an account? <a href="/register" class="text-dark fw-bold">Sign Up</a>
                            </p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>
