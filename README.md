Code is commented.

### Backend examples for Daily Bucket App


1) First example: [REST API](https://medium.com/extend/what-is-rest-a-simple-explanation-for-beginners-part-1-introduction-b4a072f8740f)  with [CRUD](https://www.codecademy.com/articles/what-is-crud) operations
2) Second example: First example using [MySQL](https://www.mysql.com/) database with [ORM](https://en.wikipedia.org/wiki/Object-relational_mapping): [OrmLite](http://ormlite.com/).
### Running

1) `git clone https://github.com/szabi22/DailyBucket.git`
2) `cd DailyBucket`
2) `git checkout feri_examples`
3) Open backend folder with [IntelliJ](https://www.jetbrains.com/idea/)
4) Few steps:
   * Open up *Maven* side-menu (right side of screen)
   * Drop down **backend**
   * Drop down **Plugins**
   * Drop down **spring-boot**
   * Double click `spring-boot:run`
   
#### Second Example

In order to run this example:
**MySQL server should be installed and should be running**.

1) `git pull`
2) Create database `dailybucket`
3) Create database user `dailybucket` with password `password123`
4) Grant all privileges for user on `dailybucket` database
5) The rest of the steps are the same as for the first example

- [How To Create a New User and Grant Permissions in MySQL](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql)
- [Data Acess Object (DAO)](https://en.wikipedia.org/wiki/Data_access_object)
### Testing

Recommended tool: [POSTMAN](https://www.getpostman.com/downloads/)