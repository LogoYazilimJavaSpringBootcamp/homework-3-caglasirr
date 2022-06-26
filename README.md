ActiveMQ, Kafka ve RabbitMQ karşılaştırın. Örnek kodlar ile nasıl çalıştığını
anlatın. (10 Puan)

** Kafka dumb-broker / smart consumer modelini kullanılır. Bunun anlamı; broker kendisinden bir mesaj talep edildiğinde o mesajı verir ancak mesajın iletilip iletilmediği ile ilgilenmez veya queue içerisinde cursor’ın nerede kaldığını bilmez. Cursor’ın nerede kaldığını consumer bilmek zorundadır. Büyük ölçekli mesajlaşma uygulamalarında kullanılır. Bunun nedeni mesajların kaybolmamasıdır, yani kullanıcı videoyu geri sarmak istediğinde sarabilir. Cursor’ın queue ‘da nerede kalındığını consumer’ın bilmesini ve yönetmesini (consumer-centric) istiyorsak, mesajarın kalıcı olmasını istiyorsak Kafka kullanmalıyız. Ancak
.NET ortamına resmi olarak destekleri yoktur ve sadece Native Kafka Protocol protokolünü kullanır.<br>

** RabbitMQ smart-broker /dumb consumer modelini kullanır. Yani burada cursor’ın nerede kaldığını broker bilmek zorundadır. Broker mesajın iletilip iletilmediğini kendisine ulaşan bir acknowledge sayesinde takip eder. Böylece mesajın consumer’a iletimi garanti altına alınmış olur. Mesajın ulaşmasını garanti altına almak istiyorsak, farklı protokoller kullanmak istiyorsak(AMQP 0–9–1, STOMP, MQTT, AMQP 1.0)
ve Cursor’ın queue’da nerede kaldığını broker’ın belirlemesini (broker-centric) istiyorsak Rabbit MQ kullanmalıyız.<br>

• Microservis ve monolith mimariyi karşılaştırın.(10 Puan)

Monolith mimaride uygulamanın küçük bir kısmında yapılan bir değişiklik, projenin tümünün yeniden derlenmesi ve tüm uygulamanın deploy edilmesini gerektirir. Bunun aksine, microservicelerde yalnızca değiştirdiğimiz hizmetleri yeniden build ve deploy etmemiz yeterlidir. Monolith mimaride birbirlerine olan bağımlılıklarından dolayı, bir component için yapılan değişimden diğer component’in etkilenebilir.
Yine Monolith mimaride, Tüm component’lerin aynı framework, aynı programlama dili ile geliştirilmesi gereklidir.<br>

MicroService yapısı sürekli ve plansız bir şekilde büyüyen monolithic yapıdaki servislerin, beraberinde getirdiği karmaşıklığı ve yönetim zorluklarını çözmeye odaklanmaktadır. Servisler farklı dillerde ve farklı framework’lerde geliştirilebilir Birbirlerinden bağımsız olarak her bir servis değişebilir, kolay test ve build yapılabilir. Continuous delivery’e olanak sağlar ve hızlı deployment’lar gerçekleştirilebilir. Her bir servisi birbirinden bağımsız olarak scale edebilme olanağı sağlar. Versiyonlama kolay bir şekilde yapılabilecektir.

• SOAP - RESTful karşılaştırın (10 Puan)

** Rest aslında SOAP gibi bir standart değil, içerisinde HTTP, URL, JSON, XML gibi standartları barındıran bir mimaridir. REST (Representational State Transfer), yine SOAP gibi client-server arasında hızlıca ve kolay bir şekilde iletişimi sağlamak için kurulmuş bir yapıdır. SOAP’ta mesaj alışverişi GetProduct, GetBooks gibi metotlar üzerinden yapılırken Rest http metotlarını kullanır (PUT, DELETE, POST, GET). Rest mimarisi ile geliştirilen servislere genel olarak RESTful servis denir.
Güvenlik açısından SOAP için hazır fonksiyonlar bulunmaktadır ve daha kompleks oluşu onu bu konuda daha avantajlı yapar. REST için güvenlik söz konusu olduğunda SOAP’a göre biraz zayıf kalmaktadır.
Uygulamamızın hızlı çalışması önemli ise REST kullanmak daha uygundur.<br> 

** Her ikisi de HTTP protokolünü kullanır ve server-client arasındaki haberleşmeyi sağlar. Ancak REST için HTTP şarttır SOAP ise TCP/IP STMP gibi protokollere de destek verebilir.<br>

** Cachleme isteği için REST basit HTTP metodunu kullanır ve SOAP’a göre daha kolaydır. SOAP, bu işlem için karışık XML requestleri yapmaktadır.<br>

** REST ile JSON, XML, TEXT ile çalışabiliyorken, SOAP ile XML kullanmalıyız. JSON ile daha küçük boyutlarda verilerle işlemler gerçekleştirebiliyoruz.<br>

** Eğer data boyutları uygulamamız için önem arz ediyorsa REST kullanmalıyız. 

• isbasi.com üye olup sisteme 3 yeni model ekleyin ve mimariye uygun şekilde
CRUD işlemleri yapan endpointleri yazın. (50 Puan)
<br>--Expense, PaymentStatus, Currency gibi modeller eklendi. Kullanıcının (User), masraf(Expense) girişi yapabildiği, masraflarını görüntüleyebildiği, silebildiği ve güncelleyebildiği endpointler yazıldı.

• CustomerServisi için gerekli tüm endpoint’leri yazın. (10 Puan)
<br>--CustomerController'da gerekli endpointler yazıldı.

• Aktif ve pasif müşterileri listeleyen endpoint için gerekli kodu yazın. (10 Puan)
<br>--UserController'da gerekli endpointler yazıldı.
