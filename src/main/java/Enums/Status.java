package Enums;

public enum Status {
	/**
	 * 3 tipos de reservas para diferenciar el estado, si una reserva esta en reservado no puede aparecer
	 * para reservarla otra vez, si esta expirada tampoco puede aparecer, si esta entregada si puede aparecer
	 * para volverla a reservar. Por defecto, al crear una reserva se pone en reservado.
	 */
	RESERVADO, EXPIRADO, ENTREGADO
}
