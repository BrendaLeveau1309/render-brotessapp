package pe.edu.upc.brotessapp.dtos;

public class Q_W1DTO {
    private int id_notificacion;
    private String Titulo_Notificacion;
    private int Cantidad_UsuariosNotificados;

    public int getId_notificacion() {
        return id_notificacion;
    }

    public void setId_notificacion(int id_notificacion) {
        this.id_notificacion = id_notificacion;
    }

    public String getTitulo_Notificacion() {
        return Titulo_Notificacion;
    }

    public void setTitulo_Notificacion(String titulo_Notificacion) {
        Titulo_Notificacion = titulo_Notificacion;
    }

    public int getCantidad_UsuariosNotificados() {
        return Cantidad_UsuariosNotificados;
    }

    public void setCantidad_UsuariosNotificados(int cantidad_UsuariosNotificados) {
        Cantidad_UsuariosNotificados = cantidad_UsuariosNotificados;
    }
}
