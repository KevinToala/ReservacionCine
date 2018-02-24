insert into peliculas(id, titulo, descripcion, duracion, genero, url_imagen) VALUES
  (1, 'Pantera Negra',
   'T''Challa regresa a su hogar en la apartada nación africana de Wakanda para servir como líder de su país. Tras suceder a su padre en el trono, pasa a convertirse en Pantera Negra, una sigilosa criatura de la noche, con agudos sentidos felinos y otras habilidades como súper fuerza e inteligencia, agilidad, estrategia o maestro del combate sin armas. Es bajo el liderazgo de T''Challa como Wakanda consigue convertirse en una de las naciones más ricas y tecnológicamente avanzadas del planeta.',
    135, 'ACCION', 'https://www.supercines.com/MovieImages/20171122Mov005/xxhdpi.jpg'),
  (2, 'Maze Runner: La Cura Mortal',
   'Thomas no puede confiar en CRUEL. La organización le robó sus recuerdos y lo encerró en el laberinto. Luego lo dejó al borde de la muerte, en el Desierto. Ahora CRUEL asegura que el tiempo de las mentiras ha terminado. Con toda la información que reunió gracias a las Pruebas, está en condiciones de avanzar en la cura de la Llamarada. Pero Thomas debe pasar por la Prueba Final. ¿Logrará sobrevivir al procedimiento? ¿Será cierto que se terminaron las mentiras? Quizás la verdad sea más terrible aún… una solución letal, sin retorno.',
   120, 'ACCION', 'https://www.supercines.com/MovieImages/20180209Mov001/xxhdpi.jpg'),
   (3, '24 Semanas',
   'Una mujer embarazada de seis meses se enfrenta a un dilema moral y personal cuando descubre que su bebé nonato tendrá síndrome de Down y una grave malformación del corazón que podrían condenarle a llevar una vida vegetativa.',
   103, 'DRAMA', 'https://www.supercines.com/MovieImages/20170915Mov015/xxhdpi.jpg'),
   (4, 'El Hilo Fantasma',
   'En el Londres de la posguerra de 1950, el famoso modisto Reynolds Woodcock y su hermana Cyril están a la cabeza de la moda británica, vistiendo a la realeza, a estrellas de cine y a toda mujer elegante de la época. Un día el soltero Reynolds encuentra a Alma, una joven que pronto se convierte en su musa y amante. Entonces su vida cuidadosamente controlada y planificada se ve alterada por la irrupción del amor. Un retrato de un artista en un viaje creativo y de las mujeres que mantienen su mundo en funcionamiento.',
   130, 'DRAMA', 'https://www.supercines.com/MovieImages/20171124Mov005/xxhdpi.jpg'),
   (5, 'La Forma del Agua',
   'Estados Unidos, alrededor de 1963. Es la Guerra Fría y la carrera militar y espacial está en su punto más álgido. Elisa es una empleada de la limpieza muda en una instalación del Gobierno que esconde unos laboratorios secretos. Su vida cambia por completo al descubrir a un ser enigmático: un hombre-pez único, una auténtica anomalía natural, que vive encerrado y es víctima de diversos experimentos. Elisa empieza entonces a sentir simpatía por este extraño ser y se establece una fuerte conexión entre ambos. Pero el mundo real no es un lugar seguro para un hombre de estas características.',
   123, 'DRAMA', 'https://www.supercines.com/MovieImages/20171124Mov006/xxhdpi.jpg'),
   (6, 'Cincuenta Sombras Liberadas',
   'Anastasia y Christian han contraído matrimonio. Ella debe adaptarse completamente a su nuevo estatus sentimental como profesional, al ser la nueva dueña del Seattle Independent Publishing. Poco tiempo después descubrirá que está embarazada de su primer hijo con Christian y su relación peligrará, no sólo por ese miedo al compromiso de Christian sino por todas las amenazas que comenzará a sufrir Ana y que podrá en peligro su vida y la de su bebé.',
   110, 'ROMANCE', 'https://www.supercines.com/MovieImages/20171117Mov015/xxhdpi.jpg'),
   (7, 'El Payaso Siniestro',
   'Emma es una estudiante de instituto con una terrible y paralizante fobia a los payasos. A pesar de su miedo, la joven se verá obligada a enfrentarse a su peor pesadilla cuando espíritu maligno aterrorice su ciudad natal metido en el cuerpo de un payaso asesino. El siniestro bufón va dejando globos con la fecha en que morirán sus víctimas, por lo que Emma, cuando recibe su particular regalo, tendrá tan solo dos días para evitar que el payaso la asesine.',
   80, 'TERROR', 'https://www.supercines.com/MovieImages/20180207Mov001/xxhdpi.jpg'),
   (8, '¿Quién es Papá?',
   'Ed Helms y Owen Wilson interpretan a Peter y Kyle Reynolds, dos hermanos cuya excéntrica madre (Glenn Close) les ha dicho que su padre murió cuando eran jóvenes. Los hermanos pronto descubren que es una mentira y en realidad no está muerto. Por eso, emprenden un viaje en carretera en su búsqueda, aprendiendo más sobre su madre de lo que querrían saber.',
   113, 'COMEDIA', 'https://www.supercines.com/MovieImages/20180112Mov007/xxhdpi.jpg'),
   (9, 'El Pájaro Loco',
   'Lance Walters es un abogado divorciado que decide irse a vivir con su hijo y su nueva novia a una casa de ensueño en un bosque situado en las montañas. Sin embargo, allí descubrirá que para construir su hogar deberá cortar un árbol en el que vive un pájaro carpintero, contra el que empezará una guerra para decidir quién se hará con el lugar.',
   85, 'ANIMACION', 'https://www.supercines.com/MovieImages/20171117Mov014/xxhdpi.jpg'),
   (10, 'Los Oscuros Secretos del Pentágono',
   'Estados Unidos, 1971. El director del Washington Post Ben Bradlee (Tom Hanks) y la editora Katharine Graham (Meryl Streep) descubren una filtración con documentos que demostraban que la administración del presidente Lyndon B. Johnson había mentido a los ciudadanos sobre la guerra de Vietnam. Tras la decisión de este periódico de publicar los Papeles del Pentágono, se produce un gran escándalo y una batalla sin precedentes entre periodistas y Gobierno. Esta polémica revelación llegó incluso a dañar a la administración del sucesor de Johnson, Richard Nixon.',
   116, 'BIOGRAFIA', 'https://www.supercines.com/MovieImages/20171201Mov002/xxhdpi.jpg');

insert into usuarios(username, clave, nombres, apellidos, identificacion, fecha_nacimiento, rol) VALUES
  ('admin', '$2a$10$cDuprPNjRVkugNrEY1SYZelGtH54Ie78a3aHuVlNGhtiXgLo4RC26', 'Administrador', '', '9999999999999', '2000-01-01', 'ADMIN');


insert into salas(id, nombre, filas, columnas) values
  (1, 'Sala 1', 4, 2);

insert into funciones(id, sala_id, pelicula_id, fecha, horario) values
  (1, 1, 1, '2018-08-23', '09:00:00');

insert into butacas(funcion_id, fila, columna) values
  (1, 1, 1), (1, 1, 2),
  (1, 2, 1), (1, 2, 2),
  (1, 3, 1), (1, 3, 2),
  (1, 4, 1), (1, 4, 2);