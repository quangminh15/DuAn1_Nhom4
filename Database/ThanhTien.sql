use QL_CuaHangGiay
go
create proc sp_TongTien 
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

