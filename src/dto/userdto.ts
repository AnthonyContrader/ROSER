import {Usertype} from './usertype';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   userId: number;

   userName: string;

   userPass: string;

   userUser: String;

   userType: string;

   userSurname: string;
   
   userState: boolean;

}

