USE [master]
GO
/****** Object:  Database [QL_CuaHangGiay]    Script Date: 30/11/2022 2:45:02 CH ******/
CREATE DATABASE [QL_CuaHangGiay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QL_CuaHangGiay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QL_CuaHangGiay.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QL_CuaHangGiay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QL_CuaHangGiay_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QL_CuaHangGiay] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QL_CuaHangGiay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QL_CuaHangGiay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ARITHABORT OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QL_CuaHangGiay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QL_CuaHangGiay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QL_CuaHangGiay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QL_CuaHangGiay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QL_CuaHangGiay] SET  MULTI_USER 
GO
ALTER DATABASE [QL_CuaHangGiay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QL_CuaHangGiay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QL_CuaHangGiay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QL_CuaHangGiay] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QL_CuaHangGiay] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QL_CuaHangGiay] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QL_CuaHangGiay', N'ON'
GO
ALTER DATABASE [QL_CuaHangGiay] SET QUERY_STORE = OFF
GO
USE [QL_CuaHangGiay]
GO
/****** Object:  Table [dbo].[ChiTietSP]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSP](
	[MaCT] [nvarchar](50) NOT NULL,
	[MaSP] [nvarchar](50) NOT NULL,
	[Size] [float] NULL,
	[MauSac] [nvarchar](50) NULL,
	[ChatLieu] [nvarchar](50) NULL,
	[Gia] [float] NULL,
 CONSTRAINT [PK_ChiTietSP_1] PRIMARY KEY CLUSTERED 
(
	[MaCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[MaKM] [nvarchar](50) NULL,
	[NgayBan] [date] NULL,
	[MaKH] [nvarchar](50) NULL,
	[ThanhTien] [float] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonCT]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonCT](
	[MaHDCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [nvarchar](50) NULL,
	[MaCT] [nvarchar](50) NULL,
	[TenSP] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[Gia] [float] NULL,
	[TongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](255) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKM] [nvarchar](50) NOT NULL,
	[TenKM] [nvarchar](255) NULL,
	[GiamGia] [float] NULL,
	[NgayBD] [date] NULL,
	[NgayKT] [date] NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NCC]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NCC](
	[MaNCC] [nvarchar](50) NOT NULL,
	[TenNCC] [nvarchar](50) NULL,
 CONSTRAINT [PK_NCC] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Hinh] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](255) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](50) NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[MaNCC] [nvarchar](50) NULL,
	[Anh] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaNV] [nvarchar](50) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Pass] [nvarchar](50) NULL,
	[role] [bit] NULL,
 CONSTRAINT [PK_TaiKhoan_1] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC,
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT001', N'SP001', 38, N'Nâu', N'Da', 400000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT002', N'SP002', 45, N'Trắng', N'Vải', 500000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT003', N'SP003', 42, N'Đen', N'Vải', 500000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT004', N'SP004', 38, N'Trắng', N'Da', 350000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT005', N'SP001', 40, N'Đỏ', N'Vải', 2000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT006', N'SP001', 41, N'Nâu', N'Vải', 2500000)
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai]) VALUES (N'HD001', N'NV001', N'KM001', CAST(N'2022-03-12' AS Date), N'KH001', 3200000, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai]) VALUES (N'HD002', N'NV002', N'KM002', CAST(N'2012-12-24' AS Date), N'KH002', 975000, 0)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai]) VALUES (N'HD003', N'NV003', N'KM003', CAST(N'2022-01-23' AS Date), N'KH003', 1350000, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai]) VALUES (N'HD004', N'NV001', N'KM004', CAST(N'2022-05-20' AS Date), N'KH001', 4000000, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai]) VALUES (N'HD005', N'NV001', N'KM001', CAST(N'2022-04-30' AS Date), N'KH001', 5000000, 1)
GO
SET IDENTITY_INSERT [dbo].[HoaDonCT] ON 

INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (1, N'HD001', N'CT001', N'giày nike air force 1', 2, 4000000, 3200000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (3, N'HD002', N'CT002', N'JORDAN 1', 3, 1500000, 975000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (4, N'HD003', N'CT003', N'Puma RS-X3', 5, 2250000, 1350000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (5, N'HD004', N'CT004', N'giày nike air force 1', 2, 2000000, 4000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (6, N'HD005', N'CT005', N'giày nike air force 1', 2, 2500000, 5000000)
SET IDENTITY_INSERT [dbo].[HoaDonCT] OFF
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH001', N'Nguyễn Thanh Tùng', N'0879654321', N'Thái Bình')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH002', N'Lương Bích Hữu', N'0264564566', N'Tiền Giang')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH003', N'Lê Quang Hải Tú ', N'0985674576', N'TP Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH004', N'Đen Vâu', N'0588645645', N'Hưng Yên')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH005', N'Phan Lê Vy Thanh', N'0945865846', N'Kiên Giang')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH006', NULL, NULL, NULL)
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu]) VALUES (N'KM001', N'Ngày hội sinh viên', 20, CAST(N'2022-12-01' AS Date), CAST(N'2022-12-07' AS Date), NULL)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu]) VALUES (N'KM002', N'Flash Sale', 35, CAST(N'2022-12-23' AS Date), CAST(N'2022-12-24' AS Date), NULL)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu]) VALUES (N'KM003', N'Black Friday', 40, CAST(N'2022-02-25' AS Date), CAST(N'2022-02-27' AS Date), NULL)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu]) VALUES (N'KM004', N'Nay tôi vui', 40, CAST(N'2022-01-10' AS Date), CAST(N'2022-01-15' AS Date), N'Nay ông chủ vui')
GO
INSERT [dbo].[NCC] ([MaNCC], [TenNCC]) VALUES (N'NCC001', N'Nike')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC]) VALUES (N'NCC002', N'Fila')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC]) VALUES (N'NCC003', N'Adidas')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC]) VALUES (N'NCC004', N'Balenciaga')
INSERT [dbo].[NCC] ([MaNCC], [TenNCC]) VALUES (N'NCC005', N'Puma')
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV001', N'Nguyễn Văn A', 1, N'0987654321', N'a123q@gmail.com', N'Anh1.png', N'Kiên Giang')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV002', N'Trần Văn Cao', 1, N'0567567320', N'vancc123@gmail.com', N'Anh6.png', N'Bạc Liêu')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV003', N'Trần Thị Thơ', 0, N'0453453492', N'thitho123@gmail.com', N'Anh4.png', N'Hà Nội')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV004', N'Nguyễn Văn Nam', 1, N'0985456234', N'nam9899@gmail.com', N'Anh6.png', N'Vũng Tàu')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV005', N'Nguyễn Hữu Đạt', 1, N'0987896567', N'minh123@gmail.com', N'Anh3.png', N'Đắk Lắk')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi]) VALUES (N'NV006', N'a', 1, N'342342123', N'minh12@gmail.com', N'Anh5.png', N'queqwe')
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP001', N'Giày nike air force 1', 500, N'NCC001', N'Giay1.jpg', N'không có')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP002', N'JORDAN 1', 400, N'NCC005', N'Giay2.jpg', N'')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP003', N'Puma RS-X3', 300, N'NCC003', N'Giay3.jpg', N'')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP004', N'Fila Disruptor 2', 150, N'NCC002', N'Giay5.jpg', N'')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP005', N'Triple S', 400, N'NCC004', N'Giay6.jpg', N'')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu]) VALUES (N'SP006', NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV001', N'nguyenvana', N'1234', 1)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV002', N'tranvanc', N'456', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV003', N'thitho', N'123abc', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV004', N'vannam', N'678bcd', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV005', N'huudat', N'098acd', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV006', N'vulinh12345', N'1234567890', 1)
GO
ALTER TABLE [dbo].[ChiTietSP]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSP_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietSP] CHECK CONSTRAINT [FK_ChiTietSP_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([MaKM])
REFERENCES [dbo].[KhuyenMai] ([MaKM])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonCT]  WITH CHECK ADD  CONSTRAINT [FK_MA] FOREIGN KEY([MaCT])
REFERENCES [dbo].[ChiTietSP] ([MaCT])
GO
ALTER TABLE [dbo].[HoaDonCT] CHECK CONSTRAINT [FK_MA]
GO
ALTER TABLE [dbo].[HoaDonCT]  WITH CHECK ADD  CONSTRAINT [FK_MAHD] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[HoaDonCT] CHECK CONSTRAINT [FK_MAHD]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NCC] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NCC] ([MaNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NCC]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThu]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_DoanhThu](@Year int)
	as begin
	select 
	SanPham.TenSP TenSP,
	sum(HoaDonCT.SoLuong) SoLuong,
	max(ThanhTien) CaoNhat,
	min(ThanhTien) ThapNhat,
	avg(ThanhTien) TrungBinh
	from SanPham
	inner join ChiTietSP on SanPham.MaSP = ChiTietSP.MaSP
	inner join HoaDonCT on ChiTietSP.MaCT = HoaDonCT.MaCT
	inner join HoaDon on HoaDonCT.MaHD = HoaDon.MaHD
	inner join KhachHang on HoaDon.MaKH = KhachHang.MaKH
	where YEAR(NgayBan) = @Year
	group by SanPham.TenSP
	end
GO
/****** Object:  StoredProcedure [dbo].[sp_KhachHang]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_KhachHang](@Month int,@Year int)
as begin
select top 1 KhachHang.MaKH MaKH, KhachHang.TenKH TenKH, sum(cast(HoaDonCT.SoLuong as int)) SoLuong, sum(TongTien) TongTien from KhachHang
inner join HoaDon on KhachHang.MaKH = HoaDon.MaKH
inner join HoaDonCT on HoaDonCT.MaHD = HoaDon.MaHD
where HoaDon.MaKH in
                       (select MaKH
                       from HoaDon
					   where month(NgayBan) = @Month and year(NgayBan) = @Year)
group by  KhachHang.MaKH, KhachHang.TenKH
end

GO
/****** Object:  StoredProcedure [dbo].[sp_TongTien]    Script Date: 30/11/2022 2:45:02 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_TongTien] 
	@mahd nvarchar(50) 
as 
declare @tong float
	set @tong =  (select SUM(TongTien-TongTien*(km.GiamGia/100))
					from HoaDonCT ct join HoaDon hd on ct.MaHD  = hd.MaHD
					join KhuyenMai km on km.MaKM = hd.MaKM
					where ct.MaHD = @mahd 
					group by ct.MaHD)
begin
	update HoaDon
	set ThanhTien =@tong		
	where MaHD = @mahd
end

exec sp_TongTien'hd003'
GO
USE [master]
GO
ALTER DATABASE [QL_CuaHangGiay] SET  READ_WRITE 
GO
