/*
* 1. 질의어(query)
*/    
/*
SELECT 필드명
    FROM 테이블명
    JOIN 테이블명
    ON 조인 조건
    WHERE 조건
    GROUP BY 필드명
    HAVING 그룹 조건
    ORDER bY 필드명 순서(ASC,DESC);
    
갯수 조절을 위한 필드가  추가됨
*/

/* 기본 구문 */
select * from book;
select * from customer;
select * from orders;
select name, address from customer;
-- book 테이블에 있는 출판사 이름은
select distinct publisher from book;

/* 1.1 조회 조건 */
-- 가격이 10000원 이상인 책
select * from book where price >= 10000;
-- 대한미디어에서 출간한 책
select * from book where publisher='대한미디어';
-- 축구와 관련된 책
select * from book where bookname like '%축구%';
-- 가격이 10000원 이상 20000원 이하인 책
select * from book where price >= 10000 and price <= 20000;
select * from book where price between 10000 and 20000;
-- 가격이 10000원 미만 또는 20000만원 초과인 책
select * from book where price > 10000 or price <20000;
-- 가격이 13000원이 아닌 책
select * from book where price != 13000;
select * from book where price <> 13000;
--가격이 7의 배수인 책
select * from book  where mod(price, 7) = 0;
-- 나무수, 굿스포츠, 삼성당에서 출간한 책
select * from book where publisher ='나무수' or publisher ='굿스포츠' or publisher = '삼성당';
select * from book where publisher in ('나무수', '굿스포츠', '삼성당');
-- 전화가 NULL인 고객은?
select * from customer where phone is null;
-- 미국과 영국에 사는 고객은?
select * from customer where address like '%미국%' or address like '%영국%';

/*
* 1.2 순서(Order by)
*/
-- 책 이름의 오름차순(ascending order)으로 정렬
select * from book order by bookname;
-- 책 가격의 내림차순(descending order)으로 정렬
select * from book order by price desc;
-- 책 가격의 내림차순(descending order)으로 정렬, 같으면 책 이름의 오름차순으로 정렬
select * from book order by price desc, bookname;
-- 대한민국에 사는 고객을 이름순으로 정렬
select * from customer where address like '%대한민국%' order by name;

/*
*   1.3 함수
*/
--  고객의 수는?
select count(*) from customer;
select count(*) as numcustomers from customer; -- as --> alias
-- 주문의 합계, 평균, 최대, 최소는?
select sum(saleprice) as sum_sales, avg(saleprice) average_sales, max(saleprice)max_sales,min(saleprice)min_sales from orders;
-- 대한미디어에서 출간한 책 가격의 평균은?
select avg(price) from book where publisher = '대한미디어';
-- 도서번호가 1인 도서의 이름
select bookname from book where bookid = 1;
-- 가격이 20000원이상인 도서의 이름
select bookname, price from book where price >= 20000;
-- 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
select sum(saleprice) from orders where custid = 1; 
-- 박지성이 구매한 도서의 수( 박지성의 고객번호는  1번으로 놓고 작성)
select count(bookid) from orders where custid = 1;
-- 마당서점 도서의 총 개수
select count(*) from book;
-- 마당서점에 도서를 출고하는 출판사의 총 개수
select count(distinct publisher) from book;
-- 모든 고객의 이름, 주소
select name, address from customer;
-- 2014년 7월 4일~ 7원7일 사이에 주문 받은 도서의 주문번호
select orderid from orders where orderdate between '2014-07-04' and '2014-07-07';
-- 2014년 7월 4일 ~ 7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
select orderid from orders where orderdate not between '2014-07-04' and '2014-07-07';
-- 성이 '김'씨인 고객의 이름과 주소
select name,address from customer where name like '김%';
-- 성이 '김'씨이고 이름이 '아'로 끝나는 고객의 이름과 주소
select name,address from customer where name like '김%아';