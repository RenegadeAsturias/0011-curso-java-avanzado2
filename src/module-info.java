module frases {

   // El JDK ya importa por defecto el módulo 'java.base' y no es necesario.
   requires java.base;

   // En las Clases del Curso, estoy ulitizando la clase: import java.awt.Color;
   // Que no está en el módulo 'java.base' y por tanto en principio no podemos importarla
   // Pero como ya la teníamos importada antes de añadir el fichero 'module-info.java'
   // Ahora nos da error al compilar. Este es el error mostrado:
   // Package 'java.awt' is declared in module 'java.desktop', but module 'frases' does not read it
   // El error indica que el paquete 'java.awt' que contiene nuestra clase 'Color' está declarado
   // en un módulo 'java.desktop' pero no lo hemos incluído en nuestro fichero: 'module-info.java'
   // El menú contextual, nos ofrece la ayuda para solucionarlo:
   // Añade la directiva 'export java.desktop' a nuestro módulo: 'module-info.java'
   requires java.desktop;

   // veamos ahora como exportar paquetes,
   // Por defecto si no ponemos nada todos nuestros paquetes estarán ocultos
   // debemos explicitar los paquetes que queremos que sean visibles mediante la palabra exports
   exports modulos.mparrastia.frases;

}