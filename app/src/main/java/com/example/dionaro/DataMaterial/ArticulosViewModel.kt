package com.example.dionaro.DataMaterial

import androidx.lifecycle.ViewModel

class ArticulosViewModel : ViewModel(){
    val articulosRegistrados = mutableListOf<Articulos>()
    private val nombresArticulos = arrayOf("¿Qué es un seguro de gastos médicos mayores y cómo me beneficia?",
    "¿Qué se debe tomar en cuenta antes de recurrir a un crédito?",
    "Gastos personales",
    "¿Cómo ahorrar? Te contamos la fórmula del ahorro",
    "Lidiando con deudas",
    "Ingreso - ¿Qué es un ingreso?",
    "¿Qué es la inversión y cuál es su importancia?",
    "Ahorro y jubilación",
    "Consejos para elaborar un prespuesto personal")
    private val descripcionesCorta = arrayOf("¿Sabías que un seguro de gastos médicos mayores es de gran importancia para proteger tu economía?",
    "Un crédito puede significar una gran herramienta para alcanzar metas, sin embargo, antes de dar el sí a una oferta, es muy importante considerar distintos aspectos. Estos son algunos consejos que ofrece BBVA en México.",
    "Lo separaremos en dos grupos gastos de consumo y gastos de operativos",
    "La gran mayoría de las personas que tienen dificultades en sus finanzas personales y familiares usan la siguiente fórmula: errores-al-ahorrar.",
    "¿Está teniendo problemas para pagar sus facturas? ¿Está recibiendo insistentes avisos de cobro de parte de sus acreedores? ",
    "Qué es un ingreso y cómo contabilizarlo. ",
    "Una inversión en términos generales, es la utilización de los recursos en el sector productivo o de capitales con el objetivo de lograr beneficios o ganancias y su importancia radica en lograr obtener libertad financiera.",
    "Ahorro y jubilación: cómo retirarse con una pensión de más de 25,000 a través de las Afores",
    "Para poder ahorrar hay que comenzar por tener orden en nuestras finanzas personales.")
    private val descripcionesLarga = arrayOf("¿Sabías que un seguro de gastos médicos mayores es de gran importancia para proteger tu economía? Descubre por qué, a continuación.",
    "Si bien el uso de créditos permite a los usuarios construir un historial crediticio, lo más recomendable es recurrir a un nuevo crédito sólo cuando se está libre de otras deudas, de modo que la suma del pago de todos los créditos vigentes no afecte las finanzas personales cada mes.",
    "Lo separaremos en dos grupos gastos de consumo y gastos de operativos",
    "A veces pareciera que ahorrar está fuera de nuestras posibilidades, pero la verdad es que en la mayoría de los casos sí se puede ahorrar, aunque sea un monto pequeño.",
    "Si usted, o algún conocido está atravesando una tormenta financiera, considere las siguientes opciones: autoayuda usando un presupuesto realista y otras técnicas; servicios de asistencia para reducir sus deudas, como asesoramiento de crédito o de liquidación de deudas de una organización renombrada; consolidación de deudas; o bancarrota.",
    "Qué es un ingreso y cómo contabilizarlo. Recuerda que depende de si se trata de un ingreso por la venta de un producto o por la prestación de un servicio.",
    "Una inversión en términos generales, es la utilización de los recursos en el sector productivo o de capitales con el objetivo de lograr beneficios o ganancias y su importancia radica en lograr obtener  libertad financiera. Para realizar una inversión se debe contar con recursos financieros (dinero).",
    "Mantener un constante ahorro a través de una Administradora de Fondos Para el Retiro (Afore) es un buen paso para obtener una pensión a futuro, por ello, aquí detallaremos cuáles son los principales beneficios de dicho proceso.",
    "Para poder ahorrar hay que comenzar por tener orden en nuestras finanzas personales. Hoy te vamos a ayudar en esta administración individual, para que en un futuro no muy lejano puedas tener tranquilidad y libertad financiera con tu dinero.")
    private val links = arrayOf("https://www.credimejora.com/informacion-hipotecaria/seguro-gastos-medicos-mayores",
    "https://www.bbva.com/es/mx/que-se-debe-tomar-en-cuenta-antes-de-recurrir-a-un-credito/",
    "https://www.estrategiasdeinversion.com/herramientas/diccionario/economia/gastos-personales-t-1640",
    "https://www.principal.cl/ciclo-vida/la-formula-del-ahorro",
    "https://www.consumidor.ftc.gov/articulos/s0150-lidiando-con-deudas",
    "https://debitoor.es/glosario/que-es-un-ingreso",
    "https://www.ficensa.com/blog/que-es-la-inversion-y-cual-es-su-importancia.html",
    "https://www.infobae.com/america/mexico/2020/10/19/ahorro-y-jubilacion-como-retirarse-con-una-pension-de-mas-de-25000-a-traves-de-las-afores/",
    "https://afore.suramexico.com/afore/blog/como-elaborar-un-presupuesto-personal.html")
    private val textos1 = arrayOf("¿Qué es el seguro de gastos médicos mayores? Como su nombre lo indica, en caso de que sufras algún accidente o enfermedad, la aseguradora cubre los gastos hospitalarios y médicos a cambio de una prima (costo del seguro).  Un seguro de gastos médicos mayores abarca desde gastos de hospitalización, atención médica, intervenciones quirúrgicas, medicamentos y análisis clínicos, hasta otros servicios profesionales. Esto dependerá de la compañía aseguradora y del plan que contrates.   Es importante que verifiques dos conceptos antes de adquirir un Seguro de Gastos Médicos: el coaseguro y el deducible, ya que te podrían generar un impacto en tu bolsillo.  ¿Qué debo considerar al evaluar un seguro de gastos médicos mayores? Deducible: cantidad de dinero que aportas cada vez que ocurra un siniestro, para que te indemnice la aseguradora. Coaseguro: es un porcentaje que define cuánto deberás pagar del total de los gastos cubiertos por el seguro después del deducible. Por ser un porcentaje, entre mayor sea el costo del imprevisto, más tendrás que pagar. Red de Hospitales: integrada por los hospitales con los que la institución aseguradora mantiene convenio de pago y a los cuales puedes acceder. Tabulador de honorarios médicos: es el listado que especifica el monto máximo a pagar al médico tratante por cada procedimiento médico o quirúrgico.",
    "Situación financiera Hablando del uso de un crédito con la finalidad de reestructurar otra deuda, lo mejor es procurar que las condiciones de este crédito sean favorables respecto del anterior, es decir, una tasa de interés y un Costo Anual Total (CAT) más bajos, mensualidades más cómodas y un plazo tan corto como sea posible. Plazo, mensualidades y tasa de interés Si se va a solicitar un crédito por primera vez, conceptos como tasa de interés, mensualidades y plazo, son claves que se deben dominar por completo. El plazo se refiere al tiempo que tomará liquidar por completo el monto del préstamo. Por otro lado, la tasa de interés es la renta que obtiene la institución financiera por el préstamo y las mensualidades es la cantidad que se pagará mes con mes hasta liquidar la deuda.  Tomando estos tres conceptos en cuenta, se pueden tomar mejores decisiones al elegir un crédito, es decir, mensualidades cómodas, plazos menos extensos y tasas de interés más atractivas.  Solicitar tu crédito online inmediato en BBVA.",
    "Los Gastos de consumo personal se definen como los bienes y servicios que compran los individuos, los gastos operativos de instituciones sin ánimo de lucro que dan servicio a individuos y el valor de lo alimentos, gasolina, ropa, alquileres y servicios financieros que los individuos reciben como pagos en especie. La fuente primaria para estos datos es el informe mensual de ventas minoristas de la Oficina del Censo.",
    "¿Cómo se calcula la fórmula del ahorro? La gran mayoría de las personas que tienen dificultades en sus finanzas personales y familiares usan la siguiente fórmula: ingresos - gastos = Ahorros. Esta es una ecuación errónea ya que, por lo general, el recurso que sobra siempre es poco o nada. La fórmula que debe emplearse para iniciar un plan de ahorro es: ingresos - ahorros = gastos. Esta es la fórmula inteligente para poder ahorrar, aunque implique un ajuste en los gastos mensuales. De esta forma, debemos pensar de una manera distinta, pues antes de iniciar los gastos mensuales debes destinar una fracción a ahorro. Esto debe ser una rutina tan firme, que este recurso no puede ser considerado como parte de los ingresos cotidianos.",
    "Desarrollo de un presupuesto El primer paso para tomar el control de su situación financiera es hacer una evaluación realista de todos sus ingresos y de todo el dinero que gasta. Comience haciendo un listado de todas sus fuentes de ingreso. Luego, liste todos sus gastos “fijos”– aquellos que se repiten todos los meses – como por ejemplo, la cuota de su hipoteca o el alquiler, el pago mensual de su carro y las primas de seguro. A continuación haga una lista de los gastos variables, — como por ejemplo lo que gasta en el almacén, en entretenimiento y ropa. El hecho de anotar todos sus gastos, aún aquellos que parecen insignificantes, lo ayudará a hacer un seguimiento de su esquema de gastos, identificar los gastos necesarios y ordenar el resto de acuerdo a su prioridad. El objetivo de hacer su propio presupuesto es asegurarse de poder cumplir con el pago de todos los gastos básicos: vivienda, alimentación, atención de la salud, seguros y educación. Puede encontrar información sobre técnicas presupuestarias y administración de dinero en internet, en su biblioteca pública y en las librerías. Además, hay algunos programas de computación que pueden servirle para elaborar y mantener presupuestos, conciliar su libreta de cheques y crear planes para ahorrar dinero e ir saldando sus deudas.  Establezca contacto con sus acreedores Si tiene dificultades para hacer frente a sus obligaciones financieras, tome contacto con sus acreedores inmediatamente. Hágales saber por qué está teniendo problemas para cumplir con sus pagos y trate de acordar una modificación de su plan de pago que le permita reducir el monto de sus cuotas a un nivel más manejable. No espere a que sus acreedores remitan sus cuentas a una agencia de cobranza de deudas. Llegado ese punto, los acreedores le habrán perdido la fe.",
    "Un ingreso es un incremento de los recursos económicos. Éste debe entenderse en el contexto de activos y pasivos, puesto que es la recuperación de un activo.  Los ingresos suponen incrementos en el patrimonio neto de tu empresa. Puede tratarse del aumento del valor de tus activos o la disminución de un pasivo.  Sin embargo, no se contemplan las aportaciones de socios o propietarios, puesto que se entienden que es algo que la empresa debe devolver con el tiempo.  La empresa en su actividad comercial recibe dinero por prestar sus servicios o vender sus productos. De esta manera, se incrementa el patrimonio empresarial.  Por ello, los ingresos, ya sean monetarios o no, se enmarcan dentro de la ecuación de consumo y ganancia.",
    "Una inversión en términos generales, es la utilización de los recursos en el sector productivo o de capitales con el objetivo de lograr beneficios o ganancias y su importancia radica en lograr obtener  libertad financiera. Para realizar una inversión se debe contar con recursos financieros (dinero). Las inversiones aumentan por medio de los intereses, dividendos, acciones, apreciación de los bienes (incremento del valor) cuando se tiene ahorro debe visualizarse la porción y el tiempo de duración, de dicho ahorro, antes de tomar la decisión de invertir y definir donde utilizar esos recursos. Consejos para realizar  una inversión. Lo importe de no arriesgar la inversión personal es seguir ciertos criterios tomados de la experiencia para evitar los riesgos y obtener la mayor rentabilidad posible. A continuación se presentan los siguientes seis consejos para invertir.  1. Tener claro el objetivo.  2. Buscar la opción adecuada.  3. Conocer los instrumentos de inversión.  4. Definir el riesgo que desea.  5. Buscar información en el sistema financiero.  6. Hacer las preguntas que sean necesarias.",
    "De acuerdo con la Comisión Nacional del Sistema de Ahorro para el Retiro (Consar) existen tres tipos de ahorro voluntario para inflar tu pensión al llegar a la edad adulta y son: Corto Plazo  Estas aportaciones se invierten con un horizonte a corto plazo. Por ejemplo, si se requiere utilizar el dinero en un periodo corto, esta sería tu mejor opción porque se podrá disponer de él a partir de los dos meses.  Aportaciones de mediano plazo  En este caso, los ahorros deberán permanecer invertidos un mínimo de cinco años. Entre más tiempo se quede invertido el ahorro, generará mayores ganancias y se podrá alcanzar más fácilmente las metas establecidas.",
    "¿Qué es un presupuesto personal? Es un plan financiero en el cual tienes visibilidad de los ingresos que tienes en el presente y el futuro, así como también los gastos que vas a hacer. En conclusión, el presupuesto personal es un documento donde puedes ver lo que entra y sale de dinero en un periodo determinado.  Un presupuesto personal te ayuda a planificar un mejor uso de tu dinero.  Tener un plan financiero te ayuda en: Ver los ingresos que tienes Identificar gastos que sobrepasen tu ingreso Reducir gastos Planear metas financieras a futuro")
    private val textos2 = arrayOf("¿Cómo te indemnizan? Existen dos formas en las que las aseguradoras pueden cubrir los gastos médicos:   Pago directo: la aseguradora liquidará los gastos derivados de la enfermedad o accidente directamente al prestador de servicios que se tenga en convenio. Reembolso: el asegurado realiza el pago directamente al prestador de servicio y posteriormente la institución financiera reintegra los gastos que procedan. ¿Cuánto cuesta? Existen algunos factores que determinan el valor de la prima o costo, como la edad, sexo, ocupación, plan, nivel de hospitales, tabulador médico, deducible y coaseguro. ¿Qué debes tomar en cuenta antes de contratar un seguro? Busca una aseguradora que cuente con solidez financiera, de manera que pueda responder correctamente con la prestación del servicio. Recurre a asesores profesionales que te ayuden a elegir la mejor póliza de acuerdo con tus necesidades familiares. Verifica las coberturas incluidas y no incluidas, ya que frecuentemente la gente contrata un seguro médico por ser económico sin detenerse a revisar qué coberturas están incluidas o no. Cuidado con las preexistencias previstas en tu póliza, es decir, aquellas enfermedades que una persona presenta antes de la contratación del seguro médico, ya que la aseguradora no se hará cargo de los gastos. Compara no solo los precios de los diferentes seguros médicos que te ofrecen las compañías aseguradoras, sino sus coberturas y características, ya que unos pesos de diferencia en la competencia pueden darte la oportunidad de disfrutar de un seguro más completo.",
    "Historial crediticio Construir un buen historial crediticio no sólo implica tener acceso a más servicios financieros, sino también a mejores tasas de interés y condiciones de crédito en general. Mantener un récord positivo en este aspecto es un tema de compromiso y responsabilidad a largo plazo, que se convierte en un factor decisivo para decidir si es el mejor momento para obtener un crédito.  Capacidad de pago Antes de solicitar un crédito vale la pena asegurarse de que se tendrá capacidad para cubrir la deuda en su totalidad en el plazo establecido. Eso significa estar seguro de que tendrá los ingresos necesarios para pagar oportunamente, considerando todo tipo de posibles eventualidades y emergencias.  Condiciones Existen diferentes modalidades de crédito que son efectivos para distintas situaciones. Algunas de estas modalidades incluyen seguros de vida o desempleo, opción de descuento directo a nómina, tasas de interés fijas, etcétera. Todos estos factores también intervienen en la toma de decisión para elegir el mejor crédito y pueden ser de gran ayuda para solventar la deuda.  Una buen opción de crédito de fácil uso en BBVA es el Crédito de Nómina, un préstamo en moneda nacional para clientes  mexicanos que reciben el pago de su nómina, desde \$2,000 hasta \$750,000, con tasa de interés y pagos fijos durante la vigencia del préstamo. Su gran ventaja es la posibilidad de adelantar pagos sin penalización.",
    "El gasto personal es una de las subcategorías del informe de la renta personal. Para calcular el gasto personal, se suma a los gastos de consumo personal las transferencias netas al extranjero y el gasto pro intereses pagados.",
    "Otra clave del éxito financiero: tener una meta financiera definida Nadie se embarca en un bote sin tener un rumbo fijo, sin tener claro a qué puerto quiere llegar. De la misma forma, si no tenemos claras nuestras metas financieras, no tenemos un rumbo. Esto significa que es muy fácil gastar ese dinero en cosas de las cuales nos podemos arrepentir después.  Ahora bien, si estamos ahorrando para comprar una casa, para pagar la educación de nuestros hijos, para comprar un auto o para tener un retiro cómodo, entonces tenemos claro dónde queremos llegar. El tener un objetivo de ahorro nos ayuda a mantener un enfoque y le da sentido a nuestro ahorro. Además nos ayuda a planificar el monto a ahorrar periódicamente, a crear el hábito de ahorro y mantener nuestra disciplina.",
    "Servicios de asistencia para la reducción de deudas Si usted está bregando con una deuda grande en la tarjeta de crédito y no puede acordar un plan de repago con sus acreedores por sí solo, considere la posibilidad de tomar contacto con un servicio de asistencia para la reducción de sus deudas como un servicio de asesoramiento crediticio o de liquidación de deudas. Dependiendo del tipo de servicio que elija, podría recibir asesoramiento para lidiar con su creciente pila de facturas impagas o para crear un plan para repagarle a sus acreedores.  Antes de cerrar trato con un negocio de servicios de asistencia para la reducción de deudas, verifique la reputación de la compañía en la oficina de su Fiscal General estatal y en la agencia local de protección del consumidor. En estas oficinas pueden informarle si registran alguna queja contra la firma que usted está considerando. Pregunte en la oficina de su Fiscal General estatal si la compañía está obligada a obtener una licencia para operar en su estado, y si así fuera, consulte si la compañía tiene dicha licencia.  Si está pensando en conseguir ayuda para estabilizar su situación financiera, primero haga un poco de tarea. Averigüe qué servicios provee el negocio, cuánto cuestan y cuánto tiempo llevará alcanzar los resultados prometidos. No confíe en las promesas verbales. Pida que le pongan todo por escrito y lea sus contratos atentamente. Programas de liquidación de deudas Por lo general, los programas de liquidación de deudas son ofrecidos por compañías con fines de lucro e involucran la participación de la compañía en una negociación con sus acreedores para llegar a un acuerdo de liquidación o cancelación de sus deudas — una suma global inferior al monto total que usted adeuda. Para hacer este pago global, la compañía que opera el programa le pide que separe un monto específico de dinero todos los meses como una forma de ahorro. Por lo general, las compañías de liquidación de deudas le pedirán que transfiera mensualmente este monto a una cuenta tipo escrow para ir acumulando un ahorro suficiente para cancelar el acuerdo de liquidación que pudieran conseguir para usted. Además, estos programas suelen alentar o darles instrucciones a sus clientes para que dejen de efectuar los pagos mensuales a sus acreedores.",
    "Ingresos por bienes y servicios: Es importante diferenciar los ingresos por su procedencia para poder contabilizarlos. Por un lado, se encuentran aquellos procedentes por venta de bienes y, por el otro, por prestación de servicios.  Para contabilizar los ingresos por venta de bienes:  la propiedad del bien debe haberse transferido la empresa no puede seguir gestionando ese bien vendido el importe debe valorarse con fiabilidad la empresa debe recibir beneficio de la venta los costes de la operación deben valorarse con fiabilidad Para contabilizar los ingresos por prestación de servicios:  el servicio debe valorarse con fiabilidad la empresa debe recibir beneficios de la operación el grado de realización del servicio debe valorarse con fiabilidad los costes presentes y futuros consecuencia de la prestación deben valorarse",
    "Tipos  de inversión.  1. Inversiones en el campo financiero o de capitales.  2. Inversiones en el campo inmobiliario, empresarial o productivo y de proyectos.  3. Inversiones en el campo de la educación personal y, en proyección, educación para cuando se tengan hijos e hijas y previsiones para el retiro.  4.  Inversiones en bienes que con el tiempo aumentan su valor.  Instrumentos de inversión más utilizados.  1. La chequera  2. El pagare con rendimiento liquidable al vencimiento.  3. Los certificados de depósitos de los bancos  4. Los certificados de la tesorería  5. La mesa del dinero  6. Las sociedades de inversión  7. Las inversiones en unidades de inversión",
        "Largo plazo En este tipo de ahorro la inversión debe permanecer en tu cuenta hasta los 65 años de edad. Si se deja hasta su retiro (65 años), el interesado obtendrá el ahorro equivalente de pensión.  Hay que recordar que la Afore es la encargada de guardar los recursos hasta llegar a la edad de retiro y jubilación.  De acuerdo con expertos, lo ideal para tener una buena pensión a futuro es depositar el ahorro en la Afore, tomando como referencia al menos 20 veces el salario mínimo, actualmente de 123 pesos.  Sin embargo, la pensión se calcula en UMA y no en pesos mexicanos. La UMA es la referencia económica que fue creada en 2016, para determinar el pago de obligaciones como multas, créditos de Infonavit y deducciones personales.  Por lo que, el valor diario de la Unidad de Medida y Actualización es de \$86.88 pesos mexicanos, el valor mensual es de \$2,641.15 pesos mexicanos y el valor anual de \$31,693.80 pesos mexicanos.  En ese sentido, el ejemplo de una pensión por ahorro voluntario sería:  EJEMPLO: Tomando en cuenta a una persona actualmente con 50 años de edad, y un abono mensual a su Afore de alrededor de 1,720. Entonces calculando en UMA (86 pesos), su pensión a 15 años será de al menos 25,800 pesos aproximadamente.  En cambio, una persona de la misma edad, pero que inició su ahorro desde 1997, registrará una pensión de hasta 60,000 pesos aproximadamente.",
        "¿Qué ingresos hay en un presupuesto personal? Si tienes un solo trabajo coloca tu sueldo neto, prima vacacional, aguinaldo e ingresos adicionales en los meses que corresponden ejemplo:  Sueldo: de enero a diciembre, cada semana, quincena o mes. Depende de cómo te depositen tu nómina. Prima vacacional: en caso de contar con esta prestación. Aguinaldo: dependiendo la fecha en que te depositen. Prestaciones: algunas empresas ofrecen vales de despensa o bonos. Estos, inclúyelos, pues también te ayudan a pagar gastos de comida y super. ¿Qué gastos hay en un presupuesto personal? Los gastos se dividen en dos: fijos y variables.  Los fijos son aquellos gastos que debes pagar cada mes o quincena.  Los variables son aquellos como ropa o diversiones. Al haber finalizado tu presupuesto personal, revisa y replantea lo siguiente: Que no estés gastando más de lo que ganas ¿Dónde puedes recortar gastos? Tal vez puedas reemplazar gastos innecesarios por ahorro o menos diversiones y más planes a futuro. Lo mejor de tener un plan personal de gastos es que tienes el control de tu dinero, en pro de tu presente y futuro."
    )
    private val temas = arrayOf("seguros","credito","gastos","ahorro","deudas","ingresos","inversión","jubilación","presupuesto")
    private val idsArticulos = arrayOf("articulo1","articulo2","articulo3","articulo4","articulo5","articulo6","articulo7","articulo8","articulo9")

    init {
        for (i in 0 until 8) {
            val articulos = Articulos()
            articulos.nombreArticulo = nombresArticulos[i]
            articulos.descripcionCorta = descripcionesCorta[i]
            articulos.descripcionLarga = descripcionesLarga[i]
            articulos.link = links[i]
            articulos.texto1 = textos1[i]
            articulos.texto2 = textos2[i]
            articulos.tema = temas[i]
            articulos.idArticulo = idsArticulos[i]
            articulosRegistrados += articulos
        }
    }
}