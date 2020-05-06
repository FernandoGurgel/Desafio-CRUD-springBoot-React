import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { FormControl, FormArray, FormGroup, FormBuilder } from '@angular/forms';
import { faCoffee,faTrashAlt,faEdit, faTrashRestoreAlt } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  faCoffee = faCoffee
  faTrashAlt = faTrashAlt
  faTrashRestoreAlt = faTrashRestoreAlt
  faEdit = faEdit
  title = 'Contact List';
  
  myFrom: FormGroup;

  listContacts = [];
  phoneNumbers = new FormArray([]);
  contact:any = {};
  
  constructor(private service: AppService, private fb: FormBuilder){

    service.getAll().subscribe((result:[]) => {
      console.log(result);
      this.listContacts = result
    });
  }

  ngOnInit(): void {

    this.myFrom = this.fb.group({
        id: '',
        uuid: '',
        email: '',
        name: '',
        phoneNumbers: this.fb.array([]),
        gender: ''
    })
    this.myFrom.valueChanges.subscribe(console.log);
  }

  get phoneForms(){
    return this.myFrom.get('phoneNumbers') as FormArray
  }

  addPhone(){
    const phone = this.fb.control('')
    this.phoneForms.push(phone)
  }

  deletePhone(i){
    this.phoneForms.removeAt(i)
  }

  saveContact(){

    if(this.contact != undefined){
      this.service.saveContact(this.myFrom.value).subscribe((response)=>{
        window.location.reload()
      })
    }else{
      alert("fill in all fields")
    }
    
  }

  setSelectedContact(contact){
    this.myFrom.patchValue({
      name: contact.name,
      email: contact.email,
      id: contact.id,
      uuid: contact.uuid,
      gender: contact.gender,
    })
    
    for (let i=0 ; i < contact.phoneNumbers.length; i++){
      const phone = this.fb.control(contact.phoneNumbers[i])
      this.phoneForms.push(phone) 
    }
  }

  deleteContact(contact){
    if(confirm("Delete that contact?")){
      this.service.deleteContact(contact).subscribe((response)=>{
        window.location.reload()
      })
    }
  }

  contactsEmpty(){
    if(this.listContacts.length>0){
      return false;
    }else{
      return true
    }
  }

  validateFields(){
    if(this.myFrom.value.email != ''
      && this.myFrom.value.name != ''
      && this.myFrom.value.gender != ''
      ){
        return false
    }else{
      return true
    }
  }

}
