class TableroClass{
	activoId = "";
	esNuevo = false;
	tablero = new TableroModel();
	tablaData = null;
	constructor(){}
	events(){
	
      let objEvent = this;


      let template = document.getElementById( "guardarUsuario" );
      template.addEventListener( "click", function() { objEvent.setGuardar(); }, false );

      template = document.getElementById( "nuevoUsuario" );
      template.addEventListener( "click", function() { objEvent.clearData(); }, false );      
      
      
      template = document.getElementById( "cerrarUsuario" );
      template.addEventListener( "click", function() { objEvent.displayItems(false); }, false );
      
      
      template = document.getElementById( "borrarUsuario" );
      template.addEventListener( "click", function() { objEvent.borrar(); }, false );
      
	}
	getTablero(){
		let objBase = this;
		this.tablaData = $('#TableroData').DataTable({
        	ajax: 'api/datatable/usuarios',
        	columns: [
            	{ data: 'nombre' },
            	{ data: 'apellidoPaterno' },
            	{ data: 'apellidoMaterno' },
        	],
    	});
    	let objTabla = this.tablaData; 
    	$('#TableroData tbody').on('click', 'tr', function () {
        	var data = objTabla.row( this ).data();       	
        	objBase.setEditData(data); 
    	} );
		
	}
	
	setEditData(data){
		this.esNuevo = false;
		this.activoId = data.usuarioId;
		document.getElementById("nombre").value = data.nombre;
		document.getElementById("cliente").value = data.cliente;
		document.getElementById("email").value = data.email;
		document.getElementById("fechaAlta").value = data.fechaAlta;
		document.getElementById("fechaBaja").value = data.fechaBaja;
		document.getElementById("status").value = data.status;
		document.getElementById("intentos").value = data.intentos;
		document.getElementById("fechaRevocado").value = data.fechaRevocado;
		document.getElementById("fechaVigencia").value = data.fechaVigencia;
		document.getElementById("area").value = data.area;
		document.getElementById("fechaModificacion").value = data.fechaModificacion;
		document.getElementById("noAcceso").value = data.noAcceso;
		document.getElementById("usuarioId").value = data.usuarioId;
		document.getElementById("apellidoPaterno").value = data.apellidoPaterno;
		document.getElementById("apellidoMaterno").value = data.apellidoMaterno;
		document.getElementById("password").value = data.password;
		this.displayItems(true);
	} 
	
	clearData(){
		this.esNuevo = true;
		document.getElementById("nombre").value = "";
		document.getElementById("cliente").value = "";
		document.getElementById("email").value = "";
		document.getElementById("fechaAlta").value = "";
		document.getElementById("fechaBaja").value = "";
		document.getElementById("status").value = "";
		document.getElementById("intentos").value = "";
		document.getElementById("fechaRevocado").value = "";
		document.getElementById("fechaVigencia").value = "";
		document.getElementById("area").value = "";
		document.getElementById("fechaModificacion").value = "";
		document.getElementById("noAcceso").value = "";
		document.getElementById("usuarioId").value = "";
		document.getElementById("apellidoPaterno").value = "";
		document.getElementById("apellidoMaterno").value = "";
		document.getElementById("password").value = "";
		this.displayItems(true);		
	}
	
    setGuardar(){
	  let objTabla = this.tablaData;
      let tab = this.tablero;
      let base = this;
      let record = {};
      
		record.nombre = document.getElementById("nombre").value;
		record.cliente = document.getElementById("cliente").value;
		record.email = document.getElementById("email").value;
		record.fechaAlta = document.getElementById("fechaAlta").value;
		record.fechaBaja = document.getElementById("fechaBaja").value;
		record.status = document.getElementById("status").value;
		record.intentos = document.getElementById("intentos").value;
		record.fechaRevocado = document.getElementById("fechaRevocado").value;
		record.fechaVigencia = document.getElementById("fechaVigencia").value;
		record.area = document.getElementById("area").value;
		record.fechaModificacion = document.getElementById("fechaModificacion").value;
		record.NoAcceso = document.getElementById("noAcceso").value;
		record.usuarioId = document.getElementById("usuarioId").value;
		record.apellidoPaterno = document.getElementById("apellidoPaterno").value;
		record.apellidoMaterno = document.getElementById("apellidoMaterno").value;
		record.password = document.getElementById("password").value;
		
		
      
      tab.record = record;
      
      	if (this.esNuevo){
	
	      tab.newRecord().then(response => {

			console.log(response);
			
			if(response.data.error){
				alert(response.data.ErrorDesc);			
			}else{
				objTabla.ajax.reload();
				base.displayItems(false);
			}
			
			
	      }).catch(error => {
				objTabla.ajax.reload();
	      });
	      
       } else{
			
		tab.updateRecord(base.activoId).then(response => {

			console.log(response);
			
			if(response.data.error){
				alert(response.data.ErrorDesc);			
			}else{
				objTabla.ajax.reload();
				base.displayItems(false);
			}
		
	      }).catch(error => {
				objTabla.ajax.reload();
	      });
	      
	   }
		
		
    }
 
 	borrar(){
		let objTabla = this.tablaData;
		let base = this;
		let tab = this.tablero;
		tab.deleteRecord(base.activoId).then(response => {

			console.log(response);
			
			if(response.data.error){
				alert(response.data.ErrorDesc);			
			}else{
				objTabla.ajax.reload();
				base.displayItems(false);
			}
		
	      }).catch(error => {
				objTabla.ajax.reload();
	      });
	
	}
 
 
 	displayItems(showForm){

      document.getElementById("divDatosUser").style.display = 'none';
      document.getElementById("divGestionUser").style.display = 'none';
      
      if(showForm){
        document.getElementById("divDatosUser").style.display = 'block';
	  }else{
		document.getElementById("divGestionUser").style.display = 'block';
  	  }
	
	}
 
}