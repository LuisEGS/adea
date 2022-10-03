class TableUtils{
    constructor() { }
    objTable;
    set objTable(value){
      this.objTable = value;
    }
    get objTable(){
      return this.objTable;
    }


    writeTable(){
      let header = this.objTable.header ;
      let strHead= `<thead> <tr>`;
      header.forEach(record => {
        strHead += `<th scope="col" onclick=>${record.label}</th>`
      }); 
      strHead+= `</tr></thead>`;

      let strBody= ``;
      let body = this.objTable.data;
      body.forEach(record => {
        strBody += `<tr>`
        header.forEach(config =>{
          if(config.pk){
            strBody += `<td scope="row"><div class="badge rounded-pill bg-secondary ${config.classPre}" data-id=${record[config.key]}> ${record[config.key]} </div> </td>`
          }else{
            strBody += `<td scope="row">${record[config.key]}</td>`
          }
        });
        strBody += `</tr>`
      }); 
      
      strBody = `<tbody>${strBody}</tbody>`;

      return `<table class="table">${strHead} ${strBody}</table>`;
    }


}