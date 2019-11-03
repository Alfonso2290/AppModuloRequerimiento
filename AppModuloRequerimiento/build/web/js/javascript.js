

function  ajax(ruta,controlador,parametro,id,tipo)
{   var pagina=ruta+"/"+controlador+parametro;    
    var xmlhttp;
    if (window.XMLHttpRequest)
    { xmlhttp=new XMLHttpRequest();
    }
    else
    { xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
      {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
        document.getElementById(id).innerHTML=xmlhttp.responseText;
      }
      }
    xmlhttp.open(tipo,pagina,true);
    xmlhttp.send(null);    
}






function  usuario(ruta,controlador,op)
{
   document.form.action=ruta+"/"+controlador;
   document.form.method="POST";
   document.form.op.value=op;
   document.form.submit();
}

 function  entrar(ruta,controlador,op)
  {
         var  usuario=document.getElementById("txtusu").value;
         var  clave= document.getElementById("txtcla").value;
      
    if(controlador=="PersonalServlet") 
    {       
         var tiposuario=document.getElementById("tipousu").value;
         
      if(tiposuario=="0")
      {
          alert("Seleccione el  Tipo de Usuario");
          document.getElementById("tipousu").focus();
          return;
      }
      else if( usuario=="")
      {
          alert("Ingrese  Usuario !!!");
          document.getElementById("txtusu").focus();
          return;
      }else if(clave=="")
      {
          alert("Ingrese  Clave !!!");
          document.getElementById("txtcla").focus();
          return;          
      }else
      {
      
     document.form.action=ruta+"/"+controlador;
     document.form.method="POST";
     document.form.op.value=op;
     document.form.submit();  
      }
      
    }else
    {
               if( usuario=="")
              {
                  alert("Ingrese  Usuario !!!");
                  document.getElementById("txtusu").focus();
                  return;
              }else if(clave=="")
              {
                  alert("Ingrese  Clave !!!");
                  document.getElementById("txtcla").focus();
                  return;          
              }else
              {

             document.form.action=ruta+"/"+controlador;
             document.form.method="GET";
             document.form.op.value=op;
             document.form.submit();  
              }     
    }
      
 }
 
 
  //  AREA DE  MANTENIMIENTOS DE  TABLAS ----
 
 function  Mantenimiento(ruta,controlador,parametro,id,tipo)
 {  
     ajax(ruta,controlador,parametro,id,tipo);

 }
 
 function  Eliminar(ruta,controlador,parametro,id,tipo)
 {       
     var op=confirm("¿Estas seguro de Eliminar el Registro ?");
     if(op==true)
     {  alert("Registro Eliminado !!!!!");
        ajax(ruta,controlador,parametro,id,tipo);
     }     
 } 
 function  nuevo(ruta,controlador,parametro,id,tipo)
 {  
    ajax(ruta,controlador,parametro,id,tipo);
    
 }
 
 function  grabar(ruta,controlador,parametro,id,tipo)
 {    var  cod=document.form.txtcodigo.value;
      var nom=document.form.txtnombre.value;
      if(cod=='')
      {  alert("Ingrese codigo !!!");
         document.form.txtcodigo.focus();
         return ;          
      }else if(nom=='')
      {  alert("Ingrese nombre !!!");
         document.form.txtnombre.focus();
         return ;            
      }else
      { ajax(ruta,controlador,parametro+"&txtcodigo="+cod+"&txtnombre="+nom,id,tipo);
        alert("Registro Insertado !!");
      }
 } 
 function    salir(ruta,controlador,parametro,id,tipo)
 {    var op=confirm("¿Estas seguro que deseas Salir ?");
     if(op==true)
     {  ajax(ruta,controlador,parametro,id,tipo);
     }   
 } 
  function    cerrarsesionestudiante(ruta,controlador,op)
 {
          document.form.action=ruta+"/"+controlador;
          document.form.method="POST";
          document.form.op.value=op;
          document.form.submit();     
     
 }
 
 function salirgestion()
 {   var parametro="?op="+op; 
    var pagina=ruta+"/"+controlador+parametro;
    
    var xmlhttp;
    if (window.XMLHttpRequest)
      {// code for IE7+, Firefox
          //, Chrome, Opera, Safari
      xmlhttp=new XMLHttpRequest();
      }
    else
      {// code for IE6, IE5
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    xmlhttp.onreadystatechange=function()
      {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
        document.getElementById('contenido').innerHTML=xmlhttp.responseText;
        }
      }
    xmlhttp.open("GET",pagina,true);
    xmlhttp.send(null);
 }
 
 function entrargestion(ruta,controlador,op)
 {
          document.form.action=ruta+"/"+controlador;
          document.form.method="POST";
          document.form.op.value=op;
          document.form.submit(); 
     
 }  
 function  modificar(ruta,controlador,parametro,id,tipo)
 {   
     
     
     
     
   ajax(ruta,controlador,parametro,id,tipo);
     
 }
 
 
 