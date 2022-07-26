<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Add Peminjaman</title>
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
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Peminjaman</h3></div>
                            <div class="card-body">
                                <form:form id="peminjaman" action="/savePeminjaman" modelAttribute="peminjamanDto" method="POST">
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="tgl_pinjam" type="date" placeholder="Masukan Tanggal Pinjam"/>
                                        <label for="tgl_pinjam">Tanggal Pinjam</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="jumlah" type="text" placeholder="Masukan Jumlah"/>
                                        <label for="jumlah">Jumlah</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:input class="form-control" path="tgl_kembali" type="date" placeholder="Masukan Tanggal Kembali"/>
                                        <label for="tgl_kembali">Tangal Kembali</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:select class="form-control" path="id_anggota">
                                            <c:forEach var="ida" items="${anggota}">
                                                <form:option value="${ida.id}"/>
                                            </c:forEach>
                                        </form:select>
                                        <label for="id_anggota">Id Buku</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <form:select class="form-control" path="id_buku">
                                            <c:forEach var="idb" items="${buku}">
                                                <form:option value="${idb.id}"/>
                                            </c:forEach>
                                        </form:select>
                                        <label for="id_buku">Id Buku</label>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <form:button class="btn btn-primary btn-block" type="submit" id="save">Tambah Data Peminjaman</form:button>
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
