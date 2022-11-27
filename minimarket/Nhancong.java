package minimarket;

import java.util.Scanner;

abstract public class Nhancong {
    long Luong;
    String MaNC;
    private String Ten,SDT;
    private Date NgayBD;
    Scanner sc=new Scanner(System.in);

    public Nhancong(){
        NgayBD=new Date();
    }

    public Nhancong(String MaNC,String Ten,String SDT,Date NgayBD)
    {
        this.MaNC=MaNC;
        this.Ten=Ten;
        this.SDT=SDT;
        this.NgayBD=NgayBD;
    }

    public String getMaNC(){
        return MaNC;
    }

    public void setMaNC(String MaNC){
        this.MaNC=MaNC;
    }

    public String getTen(){
        return Ten;
    }

    public void setTen(String Ten){
        this.Ten=Ten;
    }

    public String getSDT(){
        return SDT;
    }

    public void setSDT(String SDT){
        this.SDT=SDT;
    }

    public Date getNgayBD(){
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD){
        this.NgayBD=NgayBD;
    }

    public void MaNC(){
        
    }

    public void Input()
    {
        MaNC();
        System.out.print("Hay nhap ten nhan cong : ");
        Ten=sc.nextLine();
        System.out.print("Hay nhap so dien thoai : ");
        SDT=sc.nextLine();
        System.out.print("Hay nhap ngay bat dau lam : ");
        NgayBD.inputDATE();
    }

    @Override
    public String toString()
    {
        return String.format("%-10s %-20s %-20s %-20s",MaNC,Ten,SDT,NgayBD.outputDATE());
    }
    
    public String toStringO()
    {
        return String.format("%-10s %-20s %-20s %-20s",MaNC,Ten,SDT,NgayBD.outputDATE());
    }

    public abstract long Luong();

}

class NhanVien extends Nhancong
{
    private int Ca;
    private String VaiTro;

    public NhanVien(){

    }
    public NhanVien(String MaNC, String Ten, String SDT, Date NgayBD, int Ca, String VaiTro){
        super(MaNC,Ten,SDT,NgayBD);
        this.Ca = Ca;
        this.VaiTro = VaiTro;
    }

    public int getCa(){
        return Ca;
    }

    public void setCa(int Ca){
        this.Ca=Ca;
    }

    public String getVaiTro(){
        return VaiTro;
    }

    public void setVaiTro(String VaiTro){
        this.VaiTro=VaiTro;
    }

    @Override
    public void MaNC(){
        System.out.println("Ma nhan vien co 2 ky tu dau la 'NV' va thu tu sau co 3 so (VD:NV001).");
        while(true)
        {
        System.out.print("Nhap ma nhan vien: ");
        MaNC = sc.nextLine();
        if(MaNC.substring(0,2).equals("NV") && MaNC.substring(2).length()==3) {break;}
        else {System.out.println("Vui long nhap lai");}
        }
    }

    public void Input(){
        super.Input();
        System.out.print("Hay nhap so ca lam trong thang:");
        Ca = Integer.parseInt(sc.nextLine());
        System.out.print("Hay nhap vai tro :");
        VaiTro = sc.nextLine();
    }

    @Override
    public String toString(){
        return super.toString()+String.format("%-15d %-20s %-20d",Ca,VaiTro,Luong());
    }

    @Override
    public long Luong()
    {
        Luong = Ca*100000;
        return Luong;
    }
}

class QuanLy extends Nhancong{
    private int KinhNghiem;
    private int rest;

    public QuanLy(){

    }

    public QuanLy(String MaNC, String Ten, String SDT, Date NgayBD, int KinhNghiem, int rest){
        super(MaNC,Ten,SDT,NgayBD);
        this.KinhNghiem = KinhNghiem;
        this.rest = rest;
    }

    public int getKinhNghiem(){
        return KinhNghiem;
    }

    public void setKinhNghiem(int KinhNghiem){
        this.KinhNghiem=KinhNghiem;
    }

    public int getRest()
    {
        return rest;
    }

    public void setRest(int rest)
    {
        this.rest = rest;
    }

    @Override
    public void MaNC(){
        System.out.println("Ma quan ly co 2 ky tu dau la 'QL' va thu tu sau co 3 so (VD:QL001).");
        while(true)
        {
        System.out.print("Nhap ma nhan vien: ");
        MaNC = sc.nextLine();
        if(MaNC.substring(0,2).equals("QL") && MaNC.substring(2).length()==3) {break;}
        else {System.out.println("Vui long nhap lai");}
        }
    }

    public void Input(){
        super.Input();
        System.out.print("Hay nhap so thang da lam :");
        KinhNghiem=Integer.parseInt(sc.nextLine());
        System.out.print("Nhap so ngay nghi trong thang: ");
        rest = Integer.parseInt(sc.nextLine());
    }  
    
    @Override
    public String toString(){
        return super.toString()+String.format("%-15d %-20d %-20d",KinhNghiem,rest,Luong());
    }

    @Override
    public long Luong()
    {
        if (rest == 0)
            Luong = 12000000 + 1500000;
        else if (rest > 0)
            Luong = 12000000 - rest*100000;
        else if (rest > 6)
            Luong = 0;
        return Luong;    
    }
} 
