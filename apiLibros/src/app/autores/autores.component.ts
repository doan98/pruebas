import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';
import '@sweetalert2/theme-bootstrap-4/bootstrap-4.css';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {LoginServicesService} from '../servicios/login-services.service'
import {  Router } from '@angular/router';




@Component({
  selector: 'app-autores',
  templateUrl: './autores.component.html',
  styleUrls: ['./autores.component.scss']
})
export class AutoresComponent implements OnInit {

  autores: any[] = [];
  listaObras: any[] = [];
  nombre: any = '';
  randon: any[]=[];
  obrasRandn: any[] = [];
  obrasFavoritas:any[]=[];


  constructor(private http: HttpClient, private modalService: NgbModal, private loginServicesService:LoginServicesService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerAutores();

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
        console.log("aqui se muestran los autores",this.autores);

        Swal.close(); // Cerrar el mensaje de carga
      },
      (error) => {
        console.log(error);
        Swal.close(); // Cerrar el mensaje de carga en caso de error
      }
    );

  }



  verObras(autor: string) {
    this.nombre = autor;

    Swal.fire({
      title: 'Cargando obras...',
      html: 'Por favor, espere...',
      allowOutsideClick: false,
      didOpen: () => {
        Swal.showLoading();
      }
    });

    this.http.get<any[]>('https://poetrydb.org/author/' + autor).subscribe(
      (response: any[]) => {
        this.listaObras = response.map((obra: any) => obra.lines.join('\n'));
        console.log("aqui muestro los fragmentos de las obras",this.listaObras);

        Swal.close();

       this.obtenerObrasRandon(autor);
       this.modalService.open('obrasModal', {centered:true})


      },
      (error) => {
        console.log(error);
        Swal.close();
      }
    );

  }

  /* api que utilize para comporbar los litulos de las obras, la fomra como lo hice agregando un dimamismo,
   cuando se da click en el boton ver obras se cargan los valores en la columna obras randon */

   obtenerObrasRandon(autor: any) {
    this.http.get<any[]>('https://poetrydb.org/random/10/author,title.json?author'+ autor).subscribe(
      (response: any[]) => {
        const obrasRandn = response.map((obra: any) => obra.title);
        console.log("aqui se muestran los titulos de las obras ",obrasRandn);

        this.obrasRandn[autor] = obrasRandn;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  agregarAFavoritos(obra: string) {
    // Aquí puedes implementar la lógica para agregar la obra a la lista de favoritos
    console.log('Obra agregada a favoritos:', obra);

    // Por ejemplo, podrías tener una lista de obras favoritas en la clase AutoresComponent y agregar la obra a dicha lista
    this.obrasFavoritas.push(obra);
  }

  cerrarSesion(): void{
    console.log("cerro")
    this.loginServicesService.logout();
    this.router.navigate(['/login']);


  }











}
