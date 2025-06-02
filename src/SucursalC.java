package src;
// Enumeración para las sucursales
enum Sucursal {
    COYOACAN,
    SAN_ANGEL,
    TEPITO,
    CIUDAD_PELUCHE,
    PUEBLO_PALETA
}

public class SucursalC {
    private Sucursal suc;

    // Constructor
    public SucursalC(Sucursal suc){
        this.suc = suc;
    }

    // Getter
    public Sucursal getSuc() {
        return suc;
    }

    // Setter
    public void setSuc(Sucursal suc){
        this.suc = suc;
    }

    @Override
    public String toString() {
        return suc.toString();
    }
}