<img src="https://camo.githubusercontent.com/326495846129afe6408603d0f201f7662bef429642a1989fb01554795a734ef5/68747470733a2f2f636972636c6563692e636f6d2f67682f6e67756f69616e7068752f73656c656e69756d2d746573746e672d6d6176656e2e7376673f7374796c653d737667" alt="Circle CI" data-canonical-src="https://circleci.com/gh/nguoianphu/selenium-testng-maven.svg?style=svg" style="max-width: 100%;"><img loading="lazy" src="https://www.repostatus.org/badges/latest/active.svg" alt="" width="100" height="20" class="alignnone size-full wp-image-12070">

# FinalCaseA101 "readme-to-test"
## This repository has been created for testing this application for the Patika A101 Test Otomasyon Practicum as a task

<h2 dir="auto"><a id="user-content--built-with" class="anchor" aria-hidden="true" href="#-built-with"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="computer" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f4bb.png">💻</g-emoji> Built with</h2>

jAVA, SELENIUM WEBDRIVER LIBRARY, TESTNG FRAMEWORK, MAVEN BUILD, PAGE OBJECT MODAL

<h2 dir="auto"><a id="user-content-️-installation-steps" class="anchor" aria-hidden="true" href="#️-installation-steps"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="hammer_and_wrench" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f6e0.png">🛠️</g-emoji> Installation Steps</h2>
  
```
mvn test -DsuiteXmlFile=testng.xml
```
<h2 dir="auto"><a id="user-content--demo" class="anchor" aria-hidden="true" href="#-demo"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="rocket" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f680.png">🚀</g-emoji> Demo</h2>
  
![](https://github.com/unaltugrul/FinalCaseA101/blob/main/31.10.2022_17.22.38_REC.gif)

## Test Scenarios
TestCase1

Feature : add product to cart by logging in

<ul dir="auto">
<li>1-User navigates to "https://www.hepsiburada.com/" web page</li>
<li>2-user accepts cookies</li>
<li>3-User hovers over "Giris Yap veya uye ol" button</li>
<li>4-User clicks to "Giris Yap" option from opened dropdown menu</li>
<li>5-User enters email address to input box</li>
<li>6-User enters password to input box and press to enter key</li>
<li>7-Verify that user is able to log in successfully</li>
<li>8-User enters product name to search box and press enter key</li>  
<li>9-User selects the product</li>
<li>10-User adds product from two different seller</li>  
<li>11-User clicks "sepete git" button</li>
<li>12-Verify that correct product has been added correctly to cart</li>
</ul>

TestCase2
  
Feature : add product to cart without by logging in 

<ul dir="auto">  
<li>1-User navigates to home page</li>
<li>2-user accepts cookies</li>
<li>3-User enters product name to search box and press enter key</li>
<li>4-User selects the product</li>
<li>5-User adds product from two different seller</li>  
<li>6-User clicks "sepete git" button</li>
<li>7-Verify that correct product has been added correctly to cart</li>      
</ul>

### PLATFORM
```
Chrome Version 107.0.5304.88 (Official Build) (64-bit)
```
  
<h2 dir="auto"><a id="user-content--special-thanks" class="anchor" aria-hidden="true" href="#-special-thanks"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="bow" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f647.png">🙇</g-emoji> Special Thanks</h2>  

<a href="/" aria-current="page" class="brand w-nav-brand w--current" aria-label="home"><img src="https://global-uploads.webflow.com/6097e0eca1e87557da031fef/609859a191abe5d64b17fed3_Patika%20logo.png" sizes="(max-width: 991px) 100px, 120px" srcset="https://global-uploads.webflow.com/6097e0eca1e87557da031fef/609859a191abe5d64b17fed3_Patika%20logo-p-500.png 500w, https://global-uploads.webflow.com/6097e0eca1e87557da031fef/609859a191abe5d64b17fed3_Patika%20logo.png 706w" alt="Patika.dev logosu" class="header-logo" style="width:83px"></a>
  
<h2 dir="auto"><a id="user-content--sponsors" class="anchor" aria-hidden="true" href="#-sponsors"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a><g-emoji class="g-emoji" alias="bow" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/1f647.png">🙇</g-emoji> Sponsors</h2>  
<a href="/" class="logo" title="A101"><img loading="lazy" src="https://ayb.akinoncdn.com/static_omnishop/ayb796/assets/img/logo%40a101-2x.png" alt="" style="width:83px">
      </a>
