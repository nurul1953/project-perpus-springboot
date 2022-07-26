<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Add Buku</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Buku</h3></div>
                            <div class="card-body">
                                <form:form id="buku" action="/saveBuku" modelAttribute="bukuDto" method="POST">
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="judul" type="text" placeholder="Masukan Judul"/>
                                        <label for="judul">Judul Buku</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="pengarang" type="text" placeholder="Masukan Pengarang"/>
                                        <label for="pengarang">Pengarang</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:select class="form-control" path="jenis">
                                            <form:option value="Antologi"/>
                                            <form:option value="Biografi"/>
                                            <form:option value="Cergam"/>
                                            <form:option value="Dongeng"/>
                                            <form:option value="Ensiklopedi"/>
                                            <form:option value="Ilmu Pengetahuan"/>
                                            <form:option value="Kamus"/>
                                            <form:option value="Karya Ilmiah"/>
                                            <form:option value="Komik"/>
                                            <form:option value="Novel"/>
                                        </form:select>
                                        <label for="jenis">Jenis Buku</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="penerbit" type="text" placeholder="Masukan Penerbit"/>
                                        <label for="penerbit">Penerbit</label>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <form:button class="btn btn-primary btn-block" type="submit" id="save">Tambah Data Buku</form:button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Nushrotummillah 2021</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>
</html>
