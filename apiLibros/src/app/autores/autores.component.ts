import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';
import '@sweetalert2/theme-bootstrap-4/bootstrap-4.css';


@Component({
  selector: 'app-autores',
  templateUrl: './autores.component.html',
  styleUrls: ['./autores.component.scss']
})
export class AutoresComponent implements OnInit {

  autores: any[] = [];
  obras:any[]=[];
  nombre:any[]=[];
  listaObras:any=[]=[];



  constructor(private http: HttpClient, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.obtenerAutores();
    this.obtenerObras();

  }

  obtenerAutores() {
    Swal.fire({
      title: 'Cargando autores...',
      html: 'Por favor, espere...',
      allowOutsideClick: false,
      didOpen: () => {
        Swal.showLoading();
      },
    });

    this.http.get<any[]>('https://poetrydb.org/author').subscribe(
      (response: any) => {
        this.autores = response.authors;
        console.log(this.autores);

        Swal.close(); // Cerrar el mensaje de carga
      },
      (error) => {
        console.log(error);
        Swal.close(); // Cerrar el mensaje de carga en caso de error
      }
    );
  }


  obtenerObras() {
    this.http.get<any[]>('https://poetrydb.org/title/[TITULO OBRA]').subscribe(
      (response:any) => {
        this.listaObras=response;
        response.forEach((element:any)=>{
          if(this.autores == element.authors){
            this.nombre = this.autores
            console.log(this.nombre)

          }
        })

        });

      }




}
