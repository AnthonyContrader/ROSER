import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
    port: string = '8080';
    gateway: string;
    micro1: string;
    entityName: string;

    constructor(protected http: HttpClient) {
    }

    auth() {
        var user = JSON.parse(localStorage.getItem("Autoken"));
        
        console.log(user);
        if(user) {
            return "Bearer " + user.authority;
        } else {
            return "";
        }
      }

    getAll(): Observable<DTO[]> {
        return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.gateway + '/api/' +this.entityName ,{
            headers: {
                "Authorization": this.auth()
            }
        }) ;
    }
    read(id: number): Observable<DTO> {
        return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.micro1 + '/api/' +this.entityName+ '/read?id=' + id);
    }

    delete(id: number): Observable<any> {
        return this.http.delete('http://localhost:' + this.port + '/' + this.micro1 + '/api/' +this.entityName +  '/delete?id=' + id);
    }

    insert(dto: DTO): Observable<any> {
        return this.http.post('http://localhost:' + this.port + '/' + this.micro1 + '/api/' +this.entityName + '' , dto);
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.micro1 + '/api/' +this.entityName +  '/update', dto);

    }


}