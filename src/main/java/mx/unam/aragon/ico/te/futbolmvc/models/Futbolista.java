package mx.unam.aragon.ico.te.futbolmvc.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO_INCREMENT
    private Integer id;


    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Integer numero;
    private Integer edad;
    private String club;
    private String nacionalidad;
    private String foto;

    public Futbolista() {
    }

    public Futbolista(Integer id, String nombre,
                      Integer numero,
                      Integer edad,
                      String club,
                      String nacionalidad,
                      String foto) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.edad = edad;
        this.club = club;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", edad=" + edad +
                ", club='" + club + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(numero, that.numero) && Objects.equals(edad, that.edad) && Objects.equals(club, that.club) && Objects.equals(nacionalidad, that.nacionalidad) && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, numero, edad, club, nacionalidad, foto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
