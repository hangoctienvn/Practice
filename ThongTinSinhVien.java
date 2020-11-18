package ADF2;

public class ThongTinSinhVien {
    private String maSinhVien;
    private String Ten;
    private String DiaChi;
    private String DienTHoai;

    public ThongTinSinhVien() {
        maSinhVien = "";
        Ten = "";
        DiaChi = "";
        DienTHoai = "";
    }

    public ThongTinSinhVien(String maSinhVien, String Ten, String DiaChi, String DienTHoai) {
        this.maSinhVien = maSinhVien;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.DienTHoai = DienTHoai;
    }

    public String getmaSinhVien() {
        return maSinhVien;
    }

    public void setmaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienTHoai() {
        return DienTHoai;
    }

    public void setDienTHoai(String DienTHoai) {
        this.DienTHoai = DienTHoai;
    }
}
    @Override
    public String toString() {
        return String.format("Student[]", maSinhVien,Ten,DiaChi,DienTHoai);
    }
}
