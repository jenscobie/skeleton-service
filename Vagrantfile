# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
yum remove -y -t skeleton-service
yum install -y /vagrant/target/distributions/skeleton-service-1.0.0-SNAPSHOT.x86_64.rpm
service skeleton-service start
SCRIPT

Vagrant.configure(2) do |config|
  config.vm.box = "chef/centos-6.6"
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  config.vm.provision :ansible do |ansible|
    ansible.playbook = "provision/roles/jenscobie.skeleton-service/site.yml"
    ansible.sudo = true
  end

  config.vm.provision "shell", inline: $script
end
