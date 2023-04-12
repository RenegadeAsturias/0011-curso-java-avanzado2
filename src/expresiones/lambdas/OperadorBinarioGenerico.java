package expresiones.lambdas;

@FunctionalInterface
public interface OperadorBinarioGenerico<T> {
    T aplicar(T operando1, T operando2);
}
