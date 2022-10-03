class GestionClass{
	gestion = new GestionModel();
	tablaAData = null;
	tablaIData = null;
	tablaRData = null;
	record = {};
	activoId = "";
	events(){
	
      let objEvent = this;


      let template = document.getElementById( "ActivosUsuario" );
      template.addEventListener( "click", function() { objEvent.showData("divGestionAData"); }, false );

      template = document.getElementById( "InactivosUsuario" );
      template.addEventListener( "click", function() { objEvent.showData("divGestionIData"); }, false );      
      
      
      template = document.getElementById( "RevocadosUsuario" );
      template.addEventListener( "click", function() { objEvent.showData("divGestionRData"); }, false );

      template = document.getElementById( "ActualizarUsuario" );
      template.addEventListener( "click", function() { objEvent.cambiaEstado(); }, false );      
      
      
      
	}
	
	
	getGestionA(){
		let objBase = this;
		this.tablaAData = $('#GestionAData').DataTable({
        	ajax: 'api/datatable/usuarios/A',
        	columns: [
            	{ data: 'nombre' },
            	{ data: 'apellidoPaterno' },
            	{ data: 'apellidoMaterno' },
        	],
    	});
    	let objTabla = this.tablaAData; 
    	$('#GestionAData tbody').on('click', 'tr', function () {
        	var data = objTabla.row( this ).data();       	
        	objBase.setEditData(data); 
    	} );
	}

	getGestionI(){
		let objBase = this;
		this.tablaIData = $('#GestionIData').DataTable({
        	ajax: 'api/datatable/usuarios/I',
        	columns: [
            	{ data: 'nombre' },
            	{ data: 'apellidoPaterno' },
            	{ data: 'apellidoMaterno' },
        	],
    	});
    	let objTabla = this.tablaIData; 
    	$('#GestionIData tbody').on('click', 'tr', function () {
        	var data = objTabla.row( this ).data();       	
        	objBase.setEditData(data); 
    	} );
	}

	getGestionR(){
		let objBase = this;
		this.tablaRData = $('#GestionRData').DataTable({
        	ajax: 'api/datatable/usuarios/R',
        	columns: [
            	{ data: 'nombre' },
            	{ data: 'apellidoPaterno' },
            	{ data: 'apellidoMaterno' },
        	],
    	});
    	let objTabla = this.tablaRData; 
    	$('#GestionRData tbody').on('click', 'tr', function () {
        	var data = objTabla.row( this ).data();       	
        	objBase.setEditData(data); 
    	} );
	}
	setEditData(data){
		this.activoId = data.usuarioId;
		this.record = data;
		document.getElementById("idData").value = "Nombre" + data.nombre + "Status" +  data.status;
		document.getElementById("control").style.display = 'block';
	}
	
	
	cambiaEstado(){
      let ges = this.gestion;
      let base = this;
	  base.record.status =  document.getElementById("status").value;
      ges.record = base.record;
		ges.updateRecord(base.activoId).then(response => {

			console.log(response);
			
			if(response.data.error){
				alert(response.data.ErrorDesc);			
			}else{

					base.actualiza();; 
			}
		
	     }).catch(error => {
			objTabla.ajax.reload();
	     });
	}
	
	showData(strTable){
	  let base = this;
	  base.actualiza();
      document.getElementById("divGestionAData").style.display = 'none';
      document.getElementById("divGestionIData").style.display = 'none';
      document.getElementById("divGestionRData").style.display = 'none';
      document.getElementById("control").style.display = 'none';

      document.getElementById(strTable).style.display = 'block';

	}
	
	actualiza(){
		let base = this;
		document.getElementById("control").style.display = 'none';
		base.tablaAData.ajax.reload();    
		base.tablaRData.ajax.reload(); 
		base.tablaIData.ajax.reload();
	}
	
}
