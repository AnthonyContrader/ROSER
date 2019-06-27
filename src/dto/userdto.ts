
/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Authority
 * 
 * @author Vittorio Valent
 */
export class UserDTO {
   
   id: number;

   firstName: string;

   lastName: string;

   email: string;

   imageUrl: string;
   
   activated: boolean;

   langKey: string;

   actiovationKey: string;

   resetKey: string;

   createdBy: string;

   createDate: string;

   resetDate: string;

   lastModifiedBy: string;

   lastModifiedDate: string;

   authorities: any;
}