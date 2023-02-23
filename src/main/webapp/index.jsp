<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Trek Roulette</title>
</head>
<body>
<div class="container">
    <article class="row" id="navigationControl">
        <div class="col-2"></div>
        <div class="col text-align-center">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#access">Access Terminal</button>
        </div>
        <div class="col text-align-center">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#about">About Trek Roulette</button>
        </div>
        <div class="col-2"></div>
    </article>
    <article class="row" id="episodeInformation">
        <div class="col-3"></div>
        <div class="col">
            <h6>${recommendedEpisode.seriesSeason.seriesName} Season ${recommendedEpisode.seriesSeason.season}: ${recommendedEpisode.title}</h6>
            <p>${recommendedEpisode.synopsis.summary}</p>
            <c:forEach var="credit" items="${recommendedEpisode.credits}">
                <p><c:out value="${credit.role.roleName}"></c:out>: <c:out value="${credit.person.firstName} ${credit.person.lastName}"></c:out></p>
            </c:forEach>
            <form action="generate" method="get">
                <button type="submit">Nah, get another one</button>
            </form>
        </div>
        <div class="col-3"></div>
    </article>
    <!-- Access Modal -->
    <div class="modal fade" id="access" tabindex="-1" role="dialog" aria-labelledby="accessLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="accessLabel">Access Terminal</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Not a registered user?</p>
                    <a href="#" data-dismiss="modal" data-toggle="modal" id="newRegister" data-target="#register" class="form-check-label">Register now!</a>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Register</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Modal -->
    <!-- Adapted from http://sforsuresh.in/bootstrap-modal-window-close-current-open-new-modal -->
    <div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="registerLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="registerLabel">Access Terminal</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Register for an Account</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </div>
    <!-- About Modal -->
    <div class="modal fade" id="about" tabindex="-1" role="dialog" aria-labelledby="aboutLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="aboutLabel">About Trek Roulette</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Trek Roulette is built and maintained by Tim Mirkes</p>
                    <p>More details to come...</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Recommendation Modal -->
    <div class="modal fade" id="spin" tabindex="-1" role="dialog" aria-labelledby="spinLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="spinLabel">Your random Star Trek episode is...</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>