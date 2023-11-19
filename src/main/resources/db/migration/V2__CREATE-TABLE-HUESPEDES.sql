CREATE TABLE IF NOT EXISTS huespedes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(15) NOT NULL,
  apellido VARCHAR(15) NOT NULL,
  fecha_de_nacimiento DATE NOT NULL,
  nacionalidad VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NOT NULL,
  id_reserva VARCHAR(10) NOT NULL,
  PRIMARY KEY (id),
  INDEX FK (id_reserva ASC) VISIBLE)
ENGINE = InnoDB