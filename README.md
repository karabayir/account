# account
Spring Boot Yeni Bilgiler

### Bu bir @Folksdev projesidir.


                                  ASSESSMENT


-> Senin bir tane API'ın olacak.

-> Bu API customerId ve initialCredit şeklinde 2 parametreli bir data alacak.

-> Bu dataya istinaden yeni bir account oluşturacak.

-> Bir başka endpoint ise user information dönecek.User information içerisinde;
   -name
   -surname
   -balance
   -transaction listesi
     
   olacak.

  
   BONUSLAR

-> Account ve Transactions'lar ayrı servisler olsun.	
-> Frontend olsun.
-> CI/CD 'ye önem ver(Docker)


-------------------------------------------------------------------------------------

@Entity -> Bir sınıfın veri tabanına karşılık gelen bir tablosunun olmasını sağlayan anotasyon.

FetchType.LAZY -> Account.getCustomer() çağırılana kadar Customer nesnesinin değeri initiliaze edilmior. getCustomer() denildiği zaman Hibernate araya giriyor ve gidip select sorgusunu yapıp Customer nesnesinin içerisini dolduruyor.

CascadeType.ALL -> Insert, delete, update gibi işlemler sonucunda Account'a ait bir Customer nesnesi
güncellendiyse git Customer tablosundaki o veriyi de güncelle.

Abstract Class -> Ortak özellikleri olan nesneler için kullanılır(Örnek: Base Entity).


Equasl and HashCode -> 2 aynı nesne(a,b) tanımlandığında a==b komutu false dönecektir. Çünkü == komutu adreslerine göre sonuç verir. Ancak 2 nesne aynı olsa da adresleri farklı olduğundan false dönecektir.
a.equals(b) denildiği zaman içeriklerine bakıp karar vereceği için true dönecektir. Bu içerikleri overrride ile biz de değiştirebiliriz.
Hash Kod nesnemizin değerleriyle bir unique kod(integer) oluşturuyor.Bu integer kaydediliyor. Bu nesneler aynı olduğunda hash kodu da aynı olacağından karşılaştırmaları sadece iki integer değer üzerinden sağlanacağı için daha kolay olacaktır.Set,HashSet,HashMap,HashTable gibi özel veri yapıları bu hash kodları kullanarak verileri içerisinde saklar.Bundan dolayı çok hızlılar.



