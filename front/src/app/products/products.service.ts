import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './product.class';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

	private static productUrl: string = 'http://localhost:4300/api/v1/products';
	
    private static productslist: Product[] = null;
    private products$: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);

    constructor(private http: HttpClient) { }

    getProducts(): Observable<Product[]> {
        if( ! ProductsService.productslist )
        {
            this.http.get<any>(ProductsService.productUrl).subscribe(data => {
                ProductsService.productslist = data.data;
                
                this.products$.next(ProductsService.productslist);
            });
        }
        else
        {
            this.products$.next(ProductsService.productslist);
        }

        return this.products$;
    }

    create(prod: Product): Observable<Product[]> {
    	
    	this.http.post<Product>(ProductsService.productUrl,prod).subscribe(data =>
    	{
    		ProductsService.productslist.push(prod);
            this.products$.next(ProductsService.productslist);
    	});
        
        return this.products$;
    }

    update(prod: Product): Observable<Product[]>{
    	
    	const url: string = ProductsService.productUrl+"/"+prod.id;
    	
    	this.http.patch<Product>(url,prod).subscribe(data =>
    	{
    		ProductsService.productslist.forEach(element => {
                if(element.id == prod.id)
                {
                    element.name = prod.name;
                    element.category = prod.category;
                    element.code = prod.code;
                    element.description = prod.description;
                    element.image = prod.image;
                    element.inventoryStatus = prod.inventoryStatus;
                    element.price = prod.price;
                    element.quantity = prod.quantity;
                    element.rating = prod.rating;
                }
            });
            this.products$.next(ProductsService.productslist);
    	});
    	
        

        return this.products$;
    }


    delete(id: number): Observable<Product[]>{
    	
    	const url: string = ProductsService.productUrl+"/"+id;
    	this.http.delete<Product>(url).subscribe(data =>
    	{
    		ProductsService.productslist = ProductsService.productslist.filter(value => { return value.id !== id } );
            this.products$.next(ProductsService.productslist);
    	});
        
        return this.products$;
    }
}