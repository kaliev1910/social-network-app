<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-light" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">

                            <h2 class="fw-bold mb-2 text-uppercase">Register</h2>
                            <p class="text-dark mb-5">Please enter your information to register!</p>
                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="email" id="email" class="form-control form-control-lg"/>
                                <label class="form-label" for="email">Email</label>
                            </div>
                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="text" id="username" class="form-control form-control-lg"/>
                                <label class="form-label" for="username">Username</label>
                            </div>


                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="password" id="password" class="form-control form-control-lg"/>
                                <label class="form-label" for="password">Password</label>
                            </div>

                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                <input type="password" id="confirmPassword" class="form-control form-control-lg"/>
                                <label class="form-label" for="confirmPassword">Confirm Password</label>
                            </div>

                            <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-dark btn-lg px-5"
                                    type="submit"><a href="register" methods="post"> Register</a>

                            </button>

                        </div>

                        <div>
                            <p class="mb-0">Already have an account? <a href="/login"
                                                                        class="text-dark fw-bold">Login</a>
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
