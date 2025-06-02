
enum sucursal {
    Coyoacan,
    San_angel,
    Tepito,
    Ciudad_peluche,
    pueblo_paleta
}

public class SucursalClass {
    private  sucursal suc;
    //metodo constructor
    public SucursalClass(sucursal suc){
        this.suc=suc;
    }
    //metodo get
    public sucursal getSuc() {
        return suc;
    }
    //metodo set
    public void setSuc(sucursal suc){
        this.suc=suc;
    }

}
