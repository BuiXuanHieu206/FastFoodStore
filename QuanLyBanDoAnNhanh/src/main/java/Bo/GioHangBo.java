package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;

public class GioHangBo {
public ArrayList<GioHangBean> ds= new ArrayList<GioHangBean>();
	
	public void Them(String anh, String mamon, String tenmon, Long gia, Long soluongmua){
		//Thêm vào danh sách một phần tử
		int n=ds.size();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMaMon().toLowerCase().trim().equals(mamon.toLowerCase().trim())) {
				long slm=ds.get(i).getSoLuongMua()+soluongmua;
				ds.get(i).setSoLuongMua(slm);
				return;//Thoát khỏi hàm Them
			}
		}
		GioHangBean gh= new GioHangBean(anh, mamon, tenmon, gia, soluongmua);
		ds.add(gh);
	}
	public void Xoa(String mamon){
		//Xóa một phần tử ra khỏi danh sách
		int n=ds.size();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMaMon().toLowerCase().trim().equals(mamon.toLowerCase().trim())) {
				ds.remove(i);
				break;
			}
		}
	}
	public void CapNhatSoLuong(String mamon, Long slm){
		//Sửa lại số lượng mua trong giỏ hàng
		int n = ds.size();
		for(int i=0;i<n;i++) {
			if(ds.get(i).getMaMon().toLowerCase().trim().equals(mamon.toLowerCase().trim())) {
				ds.get(i).setSoLuongMua(slm);
				return;
			}
		}
	}
	public void TraLaiToanBo() {
		ds.removeAll(ds);
	}
	public long TongTien() {
		//Tính tổng thanh toán trong danh sách
		int n=ds.size();
		long s=0;
		for(int i=0;i<n;i++) {
			s=s+ds.get(i).getThanhTien();
		}
		return s;
	}
	public int SoLuongGioHang() {
		return ds.size();
	}
}
