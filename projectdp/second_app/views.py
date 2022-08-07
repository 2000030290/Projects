from django.shortcuts import render, redirect
from django.contrib.auth import login, authenticate

# Create your views here.
from django.http import HttpResponse
from . import templates
# from .models import tb1_auth
from django.contrib.auth.models import User, auth


def second_page(request):
    return HttpResponse('<body><center><h1>this is from second_app akhil page1</h1></center></body>')


def login(request):
    return render(request, 'second_app/logintoday.html')


def signin(request):
    if request.method == 'POST':
        fname = request.POST['first_name']
        lname = request.POST['last_name']
        uname = request.POST['username']
        email = request.POST['email']
        password = request.POST['password']
        user = User.objects.create_user(username=uname, password=password, email=email, first_name=fname,
                                             last_name=lname)
        user.save();
        print('user created')
        return render(request, 'second_app/main.html')
    else:

        return render(request, 'second_app/signup.html')


def about(request):
    return render(request, 'second_app/about.html')


def mainpage(request):
    return render(request, 'second_app/main.html')
