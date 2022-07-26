<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="/dashboard">My Library</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="/login">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="/dashboard">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="/getBuku">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Buku
                    </a>
                    <a class="nav-link" href="/getAnggota">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Anggota
                    </a>
                    <a class="nav-link" href="/getPeminjaman">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Peminjaman
                    </a>
                    <a class="nav-link" href="/getAdmin">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Admin
                    </a>
                </div>
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Admin</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/dashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active">Admin</li>
                </ol>
                <div class="card mb-4">
                    <div class="card-body">
                        <c:url var="insert" value="/insertAdmin">
                        </c:url>
                        <a href="${insert}">Tambah Data Admin</a>
                    </div>
                </div>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        DataTable Admin
                    </div>
                    <div class="card-body">
                        <form:form action="/searchAdmin" modelAttribute="cari" method="POST">
                            <form:input type="text" path="cari"  placeholder="Masukan kata kunci"/>
                            <form:button type="submit">Cari</form:button>
                        </form:form>
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nama</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Aksi</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Nama</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Aksi</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="admin" items="${Admin}">
                                <tr>
                                    <td>${admin.id}</td>
                                    <td>${admin.nama}</td>
                                    <td>${admin.email}</td>
                                    <td>${admin.username}</td>
                                    <td>
                                        <c:url var="deleteAdmine" value="/deleteAdmin">
                                            <c:param name="id" value="${admin.id}"/>
                                        </c:url>
                                        <a href="${deleteAdmin}">Hapus</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
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
<script src="js/datatables-simple-demo.js"></script>
<script src="js/tabel.js" crossorigin="anonymous"></script>
</body>
</html>