package upeu.edu.pe.colportores_crud.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;
    private String descripcion;
    private Integer entradas = 0;
    private Integer salidas = 0;
    private Integer balance = 0;

    private LocalDateTime fechaMovimiento = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public Integer getSalidas() {
        return salidas;
    }

    public void setSalidas(Integer salidas) {
        this.salidas = salidas;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", entradas=" + entradas +
                ", salidas=" + salidas +
                ", balance=" + balance +
                ", fechaMovimiento=" + fechaMovimiento +
                ", libro=" + libro +
                '}';
    }
}