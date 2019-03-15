import scala.collection.mutable.ListBuffer

class Paciente(var nombre: String="",var primerAp: String="",var segundoAp: String="",var edad: Int =0,
                var fecha : ListBuffer[String], var hora: ListBuffer[String], var bienestar: ListBuffer[Int],
                var temperatura: ListBuffer[Double], var humedad: ListBuffer[Double]){  

  def registrarDatos(){
    
  }
  
  def promedioBienestar(paciente: Paciente):Float={
    var suma =0
    for(x<-0 to paciente.bienestar.length-1){
      suma= suma+paciente.bienestar(x)
    }
    suma/3
  }
  def temperatura(paciente: Paciente):Unit={
    var max =0.0
    var horaMax=""
    var fechaMax=""
    var bienestarMax=0
    for(x<-0 to paciente.temperatura.length-1){
      if(paciente.temperatura(x)>max){
        max=paciente.temperatura(x)
        horaMax=paciente.hora(x)
        bienestarMax=paciente.bienestar(x)
        fechaMax=paciente.fecha(x)
      }
    }
    var min = max
    var horaMin=""
    var fechaMin=""
    var bienestarMin=0
    for(x<-0 to paciente.temperatura.length-1){
      if(paciente.temperatura(x)<min){
        min=paciente.temperatura(x)        
        horaMin=paciente.hora(x)
        bienestarMin=paciente.bienestar(x)
        fechaMin=paciente.fecha(x)
      }
    }
    println("Temperatura Maxima "+max+" Fecha: "+fechaMax+" Hora: "+horaMax+" Nivel de bienestar: "+bienestarMax)
    println("Temperatura Minima "+min+" Fecha: "+fechaMin+" Hora: "+horaMin+" Nivel de bienestar: "+bienestarMin)
    
  }

}

object PruebaPaciente {
  
  def main(args: Array[String]): Unit = {
    
  
    var f = ListBuffer[String]("25/10/18","26/10/18","27/10/18")
    var h = ListBuffer[String]("5:35","7:01","6:50")
    var b = ListBuffer[Int](1,2,5)
    var t = ListBuffer[Double](37.5,37.7,38)
    var hum = ListBuffer[Double](28.5,32.2,29.7)
    var p1 = new Paciente("Lorena","Trujillo","Landeros",22,f,h,b,t,hum)
    
    println("Datos paciente: ")
    println("Nombre: "+p1.nombre)
    println("Primer Apellido: "+p1.primerAp)
    println("Segundo apellido: "+p1.segundoAp)
    println("Edad: "+p1.edad)
       
    println("Promedio de bienestar "+p1.promedioBienestar(p1))
    p1.temperatura(p1)
  }
}