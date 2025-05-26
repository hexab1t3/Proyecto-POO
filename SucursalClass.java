    //sucursales, no le entendi si queria nombres o que onda
    enum sucursal {
    Coyoacan,
    San_angel,
    Tepito
    }

public class SucursalClass {
    private sucursal suc;
    //metodo constructor
    public SucursalClass(sucursal suc){
        this.suc=suc;
    }
    //metodo get
    public sucursal getSuc() {
        return suc;
    }
}
