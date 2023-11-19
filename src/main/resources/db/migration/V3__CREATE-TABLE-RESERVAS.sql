CREATE TABLE IF NOT EXISTS reservas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  id_reserva VARCHAR(10) NOT NULL,
  fecha_entrada DATETIME NOT NULL,
  fecha_salida DATETIME NOT NULL,
  valor DOUBLE NOT NULL,
  forma_pago VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT reservarHabitacion
    FOREIGN KEY (id_reserva)
    REFERENCES huespedes (id_reserva))
ENGINE = InnoDB