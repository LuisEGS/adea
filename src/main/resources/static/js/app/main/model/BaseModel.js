class BaseModel {
    #mainPath = "api/";
    #comp = "";
    entidad;
    listado;

    #record={};

    constructor(objectPath) { 
      this.#comp = objectPath 
    }

    get entidad(){
        return this.entidad;
    }

    set entidad(value){
        this.entidad = value
    }

    get record(){
      return this.#record;
    }

    set record(value){
      this.#record = value
    }

    getList(){
      let objBase = this;
      let urlBase = this.#mainPath + this.#comp;
      return new Promise((resolve,reject) =>{

        axios.get(urlBase, {
          responseType: 'json'
        })
        .then(function(res) {
          objBase.entidad = res;          

          resolve(res);
        })
        .catch(function(err) {
          reject(err);
        });
      });
    }

    newRecord(){
      let objBase = this;
      let urlBase = this.#mainPath + this.#comp;
      return new Promise((resolve,reject) =>{
        axios.post(urlBase, objBase.record )
        .then(function(res) {
          objBase.entidad = res;          
          resolve(res);
        })
        .catch(function(err) {
          reject(err);
        });
      });
    }

    updateRecord(id){
      let objBase = this;
      let urlBase = this.#mainPath + this.#comp + "\\" + id;
      return new Promise((resolve,reject) =>{
        axios.put(urlBase, objBase.record )
        .then(function(res) {
          objBase.entidad = res;          
          resolve(res);
        })
        .catch(function(err) {
          reject(err);
        });
      });
    }

    deleteRecord(id){
      let objBase = this;
      let urlBase = this.#mainPath + this.#comp + "\\" + id;
      return new Promise((resolve,reject) =>{
        axios.delete(urlBase, objBase.record )
        .then(function(res) {
          objBase.entidad = res;          
          resolve(res);
        })
        .catch(function(err) {
          reject(err);
        });
      });
    }

}