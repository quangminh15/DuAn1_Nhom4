USE [master]
GO
/****** Object:  Database [QL_CuaHangGiay]    Script Date: 11/12/2022 8:01:23 CH ******/
CREATE DATABASE [QL_CuaHangGiay]
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
/****** Object:  Table [dbo].[ChiTietSP]    Script Date: 11/12/2022 8:01:24 CH ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/12/2022 8:01:24 CH ******/
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
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonCT]    Script Date: 11/12/2022 8:01:24 CH ******/
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
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/12/2022 8:01:24 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/12/2022 8:01:24 CH ******/
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
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NCC]    Script Date: 11/12/2022 8:01:24 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NCC](
	[MaNCC] [nvarchar](50) NOT NULL,
	[TenNCC] [nvarchar](50) NULL,
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_NCC] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/12/2022 8:01:24 CH ******/
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
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/12/2022 8:01:24 CH ******/
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
	[Xoa] [bit] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/12/2022 8:01:24 CH ******/
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
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT006', N'SP001', 41, N'Nâu', N'Vải', 1000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT007', N'SP005', 30, N'Vàng', N'Da', 750000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT008', N'SP004', 40, N'Trắng', N'Vải', 750000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT009', N'SP003', 42, N'Đen', N'Vải', 1000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT010', N'SP005', 40, N'Trắng', N'Vải', 1000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT011', N'SP002', 42, N'Trắng', N'Vải', 600000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT012', N'SP001', 41, N'Đen ', N'Vải', 500000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT013', N'SP005', 40, N'Trắng', N'Vải', 1000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT014', N'SP002', 40, N'Trắng', N'Vải', 1000000)
INSERT [dbo].[ChiTietSP] ([MaCT], [MaSP], [Size], [MauSac], [ChatLieu], [Gia]) VALUES (N'CT015', N'SP003', 41, N'Đen', N'Vải', 1000000)
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD001', N'NV001', N'KM001', CAST(N'2022-12-01' AS Date), N'KH001', 4960000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD002', N'NV002', N'KM002', CAST(N'2012-12-24' AS Date), N'KH002', 975000, 0, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD003', N'NV003', N'KM003', CAST(N'2022-01-23' AS Date), N'KH003', 1350000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD004', N'NV001', N'KM004', CAST(N'2022-05-20' AS Date), N'KH001', 4000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD005', N'NV003', N'KM008', NULL, N'KH005', 4250000, 0, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD006', N'NV003', N'KM008', CAST(N'2020-12-20' AS Date), N'KH004', 2000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD007', N'NV004', N'KM007', CAST(N'2020-04-05' AS Date), N'KH007', 1500000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD008', N'NV005', N'KM007', CAST(N'2020-04-10' AS Date), N'KH006', 1500000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD009', N'NV002', N'KM007', CAST(N'2020-04-04' AS Date), N'KH008', 3000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD010', N'NV006', N'KM008', CAST(N'2021-12-24' AS Date), N'KH005', 2000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD011', N'NV006', N'KM001', CAST(N'2021-04-30' AS Date), N'KH007', 3000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD012', N'NV001', N'KM005', CAST(N'2019-10-23' AS Date), N'KH009', 1000000, 1, 1)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD013', N'NV002', N'KM001', CAST(N'2019-05-02' AS Date), N'KH005', 2000000, 1, 0)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD014', N'NV003', N'KM001', CAST(N'2022-01-26' AS Date), N'KH008', 2000000, 1, 0)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKM], [NgayBan], [MaKH], [ThanhTien], [TrangThai], [Xoa]) VALUES (N'HD015', N'NV007', N'KM008', CAST(N'2022-12-11' AS Date), N'KH011', 892500, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[HoaDonCT] ON 

INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (1, N'HD001', N'CT001', N'giày nike air force 1', 2, 4000000, 3200000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (3, N'HD002', N'CT002', N'JORDAN 1', 3, 1500000, 975000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (4, N'HD003', N'CT003', N'Puma RS-X3', 5, 2250000, 1350000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (5, N'HD004', N'CT004', N'giày nike air force 1', 2, 2000000, 4000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (6, N'HD005', N'CT005', N'giày nike air force 1', 2, 2500000, 5000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (7, N'HD006', N'CT006', N'giày nike air force 1', 2, 1000000, 2000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (8, N'HD007', N'CT007', N'Triple S', 2, 750000, 1500000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (9, N'HD008', N'CT008', N'Fila Disruptor 2', 2, 750000, 1500000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (10, N'HD009', N'CT009', N'Puma RS-X3', 3, 1000000, 3000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (11, N'HD010', N'CT010', N'Triple S', 2, 1000000, 2000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (12, N'HD011', N'CT011', N'JORDAN 1', 5, 600000, 3000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (13, N'HD012', N'CT012', N'giày nike air force 1', 2, 500000, 1000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (14, N'HD013', N'CT013', N'Triple S', 2, 1000000, 2000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (15, N'HD014', N'CT014', N'JORDAN 1', 2, 1000000, 2000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (17, N'HD001', N'CT002', N'JORDAN 1', 6, 500000, 3000000)
INSERT [dbo].[HoaDonCT] ([MaHDCT], [MaHD], [MaCT], [TenSP], [SoLuong], [Gia], [TongTien]) VALUES (18, N'HD015', N'CT004', N'Fila Disruptor 2', 3, 350000, 1050000)
SET IDENTITY_INSERT [dbo].[HoaDonCT] OFF
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH001', N'Nguyễn Thanh Tùng', N'0879654321', N'Thái Bình', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH002', N'Lương Bích Hữu', N'0264564566', N'Tiền Giang', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH003', N'Lê Quang Hải Tú ', N'0985674576', N'TP Hồ Chí Minh', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH004', N'Đen Vâu', N'0588645645', N'Hưng Yên', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH005', N'Phan Lê Vy Thanh', N'0945865846', N'Kiên Giang', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH006', N'Nguyễn Hữu Sang', N'0948657238', N'Vĩnh Long', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH007', N'Cao Hoàng Phúc', N'0853545664', N'Cần Thơ', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH008', N'Nguyễn Thị Diễm My', N'0854534645', N'Cần Thơ', 1)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH009', N'Đỗ Văn Đạt', N'0934563667', N'Trà Vinh', 0)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH010', N'Cristiano Ronaldo', N'0934634656', N'Bồ Đào Nha', 0)
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi], [Xoa]) VALUES (N'KH011', N'123', N'1231231231', N'123', 0)
GO
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM001', N'Ngày hội sinh viên', 20, CAST(N'2022-12-01' AS Date), CAST(N'2022-12-07' AS Date), NULL, 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM002', N'Flash Sale', 34, CAST(N'2022-12-23' AS Date), CAST(N'2022-12-24' AS Date), N'', 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM003', N'Black Friday', 40, CAST(N'2022-02-25' AS Date), CAST(N'2022-02-27' AS Date), NULL, 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM004', N'Nay tôi vui', 40, CAST(N'2022-12-08' AS Date), CAST(N'2022-12-15' AS Date), N'Nay ông chủ vui', 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM005', N'Săn sale giá rẻ', 20, CAST(N'2022-12-11' AS Date), CAST(N'2022-12-17' AS Date), N'', 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM006', N'Săn quà tết giảm giá sốc', 30, CAST(N'2019-01-01' AS Date), CAST(N'2019-01-15' AS Date), NULL, 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM007', N'Tưng bừng khai trương', 20, CAST(N'2020-04-01' AS Date), CAST(N'2020-04-15' AS Date), NULL, 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM008', N'Giáng sinh an lành', 15, CAST(N'2022-12-05' AS Date), CAST(N'2022-12-31' AS Date), N'', 1)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM009', N'Tết an nhiên', 40, CAST(N'2022-12-22' AS Date), CAST(N'2022-12-30' AS Date), N'', 0)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM010', N'Cuối tuần vui vẻ', 20, CAST(N'2022-12-24' AS Date), CAST(N'2022-12-25' AS Date), N'', 0)
INSERT [dbo].[KhuyenMai] ([MaKM], [TenKM], [GiamGia], [NgayBD], [NgayKT], [GhiChu], [Xoa]) VALUES (N'KM1231', N'123', 12, CAST(N'2022-12-11' AS Date), CAST(N'2022-12-21' AS Date), N'', 1)
GO
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC001', N'Nike', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC002', N'Fila', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC003', N'Adidas', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC004', N'Balenciaga', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC005', N'Puma', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC006', N'Boston', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC007', N'Cycle', 1)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC008', N'Newton', 0)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC009', N'Saucony', 0)
INSERT [dbo].[NCC] ([MaNCC], [TenNCC], [Xoa]) VALUES (N'NCC010', N'Reebok', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV001', N'Nguyễn Văn A', 1, N'0987654321', N'a123q@gmail.com', N'Anh1.png', N'Kiên Giang', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV002', N'Trần Văn Ca', 1, N'0567567320', N'vancc123@gmail.com', N'Anh1.png', N'Bạc Liêu', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV003', N'Trần Thị Thơ', 0, N'0453453492', N'thitho123@gmail.com', N'Anh3.png', N'Hà Nội', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV004', N'Nguyễn Văn Nam', 1, N'0985456234', N'nam9899@gmail.com', N'Anh6.png', N'Vũng Tàu', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV005', N'Nguyễn Hữu Đạt', 1, N'0987896567', N'huudat45@gmail.com', N'Anh5.png', N'Đắk Lắk', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV006', N'Tran Van Linh', 1, N'0962464443', N'linhteran@gmail.com', N'Anh6.png', N'Can Tho', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV007', N'Tô Hữu Đạt', 1, N'0987890876', N'dat123@gmail.com', N'Anh3.png', N'Đà Lạt', 0)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV008', N'Hồ Thị Anh Thư', 0, N'0987968574', N'thu123@gmail.com', N'anh5.png', N'Hậu Giang', 1)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV009', N'Trương Thục Oanh', 0, N'0987656789', N'thuoanh@gmail.com', N'anh2.png', N'Cần Thơ', 1)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [SDT], [Email], [Hinh], [DiaChi], [Xoa]) VALUES (N'NV010', N'Đỗ Hữu Tài', 1, N'0989876542', N'tai12@gmail.com', N'Anh3.png', N'An Giang', 1)
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP001', N'Giày nike air force 1', 500, N'NCC001', N'Giay2.jpg', N'không có', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP002', N'JORDAN 1', 400, N'NCC005', N'Giay4.jpg', N'', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP003', N'Puma RS-X3', 300, N'NCC003', N'Giay1.jpg', N'', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP004', N'Fila Disruptor 2', 150, N'NCC002', N'Giay3.jpg', N'', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP005', N'Triple S', 400, N'NCC004', N'Giay6.jpg', N'', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP007', N'Giay', 1, N'NCC001', N'Giay3.jpg', N'', 1)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP008', N'Reebok Blue', 200, N'NCC001', N'Giay6.jpg', N'', 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP009', N'Newtom Yellow', 300, N'NCC009', N'Giay7.png', N'', 0)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [MaNCC], [Anh], [GhiChu], [Xoa]) VALUES (N'SP010', N'Saucony Red', 400, N'NCC001', N'Giay2.jpg', N'', 0)
GO
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV001', N'nguyenvana', N'1234', 1)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV002', N'tranvanc', N'456', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV003', N'thitho', N'123abc', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV005', N'huudat', N'098acd', 0)
INSERT [dbo].[TaiKhoan] ([MaNV], [Username], [Pass], [role]) VALUES (N'NV007', N'dat123', N'123123', 0)
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
/****** Object:  StoredProcedure [dbo].[sp_DoanhThu]    Script Date: 11/12/2022 8:01:24 CH ******/
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
/****** Object:  StoredProcedure [dbo].[sp_KhachHang]    Script Date: 11/12/2022 8:01:24 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_KhachHang](@Month int,@Year int)
as begin
select top 1 KhachHang.MaKH MaKH, KhachHang.TenKH TenKH, NgayBan, sum(cast(HoaDonCT.SoLuong as int)) SoLuong, sum(TongTien) TongTien from KhachHang
inner join HoaDon on KhachHang.MaKH = HoaDon.MaKH
inner join HoaDonCT on HoaDonCT.MaHD = HoaDon.MaHD
where HoaDon.NgayBan in
                       (select NgayBan
                       from HoaDon join HoaDonCT on HoaDon.MaHD = HoaDonCT.MaHD
					   where month(NgayBan) = @Month and year(NgayBan) = @Year)
group by  KhachHang.MaKH, KhachHang.TenKH, NgayBan
order by SoLuong desc
end
GO
/****** Object:  StoredProcedure [dbo].[sp_TongTien]    Script Date: 11/12/2022 8:01:24 CH ******/
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
GO
USE [master]
GO
ALTER DATABASE [QL_CuaHangGiay] SET  READ_WRITE 
GO
